package com.brookmanholmes.bma.data.repository.datasource

import com.brookmanholmes.bma.data.entity.MatchEntity
import com.brookmanholmes.bma.data.entity.TurnEntity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import durdinapps.rxfirebase2.DataSnapshotMapper
import durdinapps.rxfirebase2.RxFirebaseDatabase
import io.reactivex.Observable

/**
 * Created by brookman on 9/17/17.
 */
class FirebaseDataStore() : MatchDataStore {
    val ref = FirebaseDatabase.getInstance().reference.child("v2")
    val matchRef = ref.child("matches")
    var userId: String? = FirebaseAuth.getInstance().currentUser?.uid

    override fun getMatch(id: String): Observable<MatchEntity> {
        return RxFirebaseDatabase.observeValueEvent(matchRef.child(id), MatchEntity::class.java).toObservable()
    }

    override fun getMatches(): Observable<List<MatchEntity>> {
        val list = ArrayList<MatchEntity>()
        if (userId != null) {
            RxFirebaseDatabase.observeValueEvent(ref.child("users").child(userId).child("matches"), DataSnapshotMapper.listOf(String::class.java))
                    .subscribe {
                        val refs = Array(it.size, { i -> ref.child("matches").child(it[i]) })

                        RxFirebaseDatabase.observeMultipleSingleValueEvent(*refs)
                                .subscribe {
                                    val entity: MatchEntity? = it.getValue(MatchEntity::class.java)
                                    entity?.let {
                                        list.add(it)
                                    }
                                }
                    }
        }

        return Observable.fromArray(list)
    }

    override fun addMatch(match: MatchEntity): Observable<MatchEntity> {
        val key = matchRef.push().key
        matchRef.child(key).setValue(match)

        return getMatch(key)
    }

    override fun addTurn(id: String, turn: TurnEntity) {
        val key = matchRef.child(id).child("turns").push().key
        matchRef.child(id).child("turns").child(key).setValue(turn)
    }

    override fun undoTurn(id: String) {
        matchRef.child(id).child("turns").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataSnapshot.children.lastOrNull()?.ref?.setValue(null)
            }
        })
    }

    override fun removeMatch(id: String) {
        getMatch(id)
                .subscribe {
                    userId?.let {
                        ref.child("users").child(it).child("matches").child(id).setValue(null)
                    }
                }
    }

    override fun updateMatchNotes(id: String, notes: String) {
        matchRef.child(id).child("notes").setValue(notes)
    }

    override fun updateMatchLocation(id: String, location: String) {
        matchRef.child(id).child("location").setValue(location)
    }

    companion object {
        fun convertDatabase() {

        }
    }
}