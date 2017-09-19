package com.brookmanholmes.bma.data.repository

import com.brookmanholmes.bma.data.entity.mapper.MatchMapper
import com.brookmanholmes.bma.data.entity.mapper.TurnMapper
import com.brookmanholmes.bma.data.repository.datasource.FirebaseDataStore
import com.brookmanholmes.bma.data.repository.datasource.MatchDataStore
import com.brookmanholmes.bma.domain.model.Filter
import com.brookmanholmes.bma.domain.model.match.Match
import com.brookmanholmes.bma.domain.model.turn.ITurn
import com.brookmanholmes.bma.domain.repository.MatchRepository
import io.reactivex.Observable


/**
 * Created by brookman on 9/16/17.
 */
class MatchDataRepository(val dataStore: MatchDataStore = FirebaseDataStore(),
                          val matchMapper: MatchMapper = MatchMapper(),
                          val turnMapper: TurnMapper = TurnMapper()) : MatchRepository {

    override fun observeMatch(id: String): Observable<Match> {
        return dataStore.getMatch(id)
                .map { matchMapper.mapToDomain(it) }
    }

    override fun observeMatches(filter: Filter): Observable<List<Match>> {
        return dataStore.getMatches()
                .map { it.map { matchMapper.mapToDomain(it) } }
    }

    override fun updateMatchNotes(id: String, notes: String) {
        dataStore.updateMatchNotes(id, notes)
    }

    override fun updateMatchLocation(id: String, location: String) {
        dataStore.updateMatchLocation(id, location)
    }

    override fun removeMatch(id: String) {
        dataStore.removeMatch(id)
    }

    override fun addTurn(id: String, turn: ITurn) {
        dataStore.addTurn(id, turnMapper.mapToEntity(turn))
    }

    override fun undoTurn(id: String) {
        dataStore.undoTurn(id)
    }

    override fun addMatch(match: Match): Observable<Match> {
        return dataStore.addMatch(matchMapper.mapToEntity(match))
                .map { matchMapper.mapToDomain(it) }
    }

    override fun convertDatabase() {
        FirebaseDataStore.convertDatabase()
    }
}