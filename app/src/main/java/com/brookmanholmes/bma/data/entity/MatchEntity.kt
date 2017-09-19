package com.brookmanholmes.bma.data.entity

/**
 * Created by brookman on 9/16/17.
 */
data class MatchEntity(val matchId: String,
                       val playerId: String,
                       val opponentId: String,
                       val playerName: String,
                       val opponentName: String,
                       val gameType: Int,
                       val turn: Int,
                       val breakType: Int,
                       val playerRank: Int,
                       val opponentRank: Int,
                       val notes: String,
                       val location: String,
                       val date: Long,
                       val details: Int,
                       val maxAttemptsPerGame: Int = 1,
                       val turns: Map<String, TurnEntity>)