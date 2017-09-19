package com.brookmanholmes.bma.data.entity

/**
 * Created by brookman on 9/16/17.
 */
data class TurnEntity(val turnEnd: Int,
                      val gameType: Int,
                      val tableStatus: String,
                      val isFoul: Boolean,
                      val isSeriousFoul: Boolean,
                      val advStats: AdvStatsEntity,
                      val playerId: String)