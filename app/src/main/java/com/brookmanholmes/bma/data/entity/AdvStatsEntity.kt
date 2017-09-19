package com.brookmanholmes.bma.data.entity

/**
 * Created by brookman on 9/16/17.
 */
data class AdvStatsEntity(val shotType: Int,
                          val shotSubType: Int,
                          val howTypes: Int,
                          val angles: Int,
                          val cbToOb: Float,
                          val obToAimPoint: Float,
                          val speed: Int,
                          val cueX: Int,
                          val cueY: Int,
                          val player: String)