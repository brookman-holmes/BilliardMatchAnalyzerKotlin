package com.brookmanholmes.bma.data.repository.datasource

import com.brookmanholmes.bma.data.entity.MatchEntity
import com.brookmanholmes.bma.data.entity.TurnEntity
import io.reactivex.Observable

/**
 * Created by brookman on 9/16/17.
 */
interface MatchDataStore {
    /**
     * Get an {@link Observable} which will emit a {@link MatchEntity} by its id.
     *
     * @param id The id of the match.
     */
    fun getMatch(id: String): Observable<MatchEntity>

    /**
     * Get an {@link Observable} which will emit a List of {@link MatchEntity}.
     */
    fun getMatches(): Observable<List<MatchEntity>>

    /**
     * Add a match to the database
     * @param match The match to add to the database
     */
    fun addMatch(match: MatchEntity): Observable<MatchEntity>

    /**
     * Adds a turn to a match
     * @param id The id of the match to add a turn to
     * @param turn The turn to add to the match
     */
    fun addTurn(id: String, turn: TurnEntity)

    /**
     * Remove the last turn in a match
     * @param id the id of the match to undo the last turn from
     */
    fun undoTurn(id: String)

    /**
     * Removes a match from the database
     * @param id The id of the match to remove
     */
    fun removeMatch(id: String)

    /**
     * Updates the notes of a match
     * @param id The id of the match to update
     * @param notes The notes to set for the match
     */
    fun updateMatchNotes(id: String, notes: String)

    /**
     * Updates the location of a match
     * @param id The id of the match to update
     * @param location The location of the match
     */
    fun updateMatchLocation(id: String, location: String)
}