package com.brookmanholmes.bma.domain.repository

import com.brookmanholmes.bma.domain.model.Filter
import com.brookmanholmes.bma.domain.model.match.Match
import com.brookmanholmes.bma.domain.model.turn.ITurn
import io.reactivex.Observable

/**
 * Created by brookman on 9/16/17.
 */
interface MatchRepository {
    /**
     * Get a {@link Observable} which will emit a {@link Match}
     * @param id The match id used to retrieve the match data
     */
    fun observeMatch(id: String): Observable<Match>

    /**
     * Get a {@link Observable} which will emit a list of {@link Match}
     * @param filter The filter used to remove unwanted matches from the list
     */
    fun observeMatches(filter: Filter): Observable<List<Match>>

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

    /**
     * Removes a match from the database
     * @param id The id of the match to remove
     */
    fun removeMatch(id: String)

    /**
     * Adds a turn to a match
     * @param id The id of the match to add a turn to
     * @param turn The turn to add to the match
     */
    fun addTurn(id: String, turn: ITurn)

    /**
     * Remove the last turn in a match
     * @param id the id of the match to undo the last turn from
     */
    fun undoTurn(id: String)

    /**
     * Add a match to the database
     * @param match The match to add to the database
     */
    fun addMatch(match: Match): Observable<Match>

    /**
     * Convert old style of database to the new style
     */
    fun convertDatabase()
}