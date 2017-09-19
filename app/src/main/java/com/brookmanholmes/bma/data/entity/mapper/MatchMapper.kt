package com.brookmanholmes.bma.data.entity.mapper

import com.brookmanholmes.bma.data.entity.MatchEntity
import com.brookmanholmes.bma.data.entity.TurnEntity
import com.brookmanholmes.bma.data.entity.decodeEnumSet
import com.brookmanholmes.bma.data.entity.encodeEnumSet
import com.brookmanholmes.bma.domain.model.game.BreakType
import com.brookmanholmes.bma.domain.model.game.GameType
import com.brookmanholmes.bma.domain.model.match.Match
import java.util.*
import kotlin.collections.HashMap

/**
 * Created by brookman on 9/17/17.
 */
class MatchMapper(val turnMapper: TurnMapper = TurnMapper()) : Mapper<MatchEntity, Match> {
    override fun mapToDomain(type: MatchEntity): Match {
        return Match.Builder(type.playerId, type.opponentId)
                .setBreakType(BreakType.values()[type.breakType])
                .setDate(Date(type.date))
                .setDetails(decodeEnumSet(type.details, Match.StatsDetail::class.java))
                .setLocation(type.location)
                .setMatchId(type.matchId)
                .setPlayerRanks(type.playerRank, type.opponentRank)
                .setNotes(type.notes)
                .setPlayerNames(type.playerName, type.opponentName)
                .setMaxAttemptsPerGhostGame(type.maxAttemptsPerGame)
                .build(GameType.values()[type.gameType])
    }

    override fun mapToEntity(type: Match): MatchEntity {
        val map = HashMap<String, TurnEntity>()
        for ((index, value) in type.turns.withIndex()) {
            map.put("key_" + index, turnMapper.mapToEntity(value))
        }
        return MatchEntity(type.matchId,
                type.player.id,
                type.opponent.id,
                type.player.name,
                type.opponent.name,
                type.initialGameStatus.gameType.ordinal,
                type.initialGameStatus.turn.ordinal,
                type.initialGameStatus.breakType.ordinal,
                type.player.rank,
                type.opponent.rank,
                type.notes,
                type.location,
                type.createdOn.time,
                encodeEnumSet(type.details),
                type.initialGameStatus.maxAttemptsPerGame,
                map)
    }
}