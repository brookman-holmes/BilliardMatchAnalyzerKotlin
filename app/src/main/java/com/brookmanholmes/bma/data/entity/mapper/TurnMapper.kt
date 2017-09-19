package com.brookmanholmes.bma.data.entity.mapper

import com.brookmanholmes.bma.data.entity.TurnEntity
import com.brookmanholmes.bma.domain.model.game.BallStatus
import com.brookmanholmes.bma.domain.model.game.GameType
import com.brookmanholmes.bma.domain.model.turn.*
import org.apache.commons.lang3.StringUtils

/**
 * Created by brookman on 9/17/17.
 */
class TurnMapper(val advStatsMapper: AdvStatsMapper = AdvStatsMapper()) : Mapper<TurnEntity, ITurn> {
    override fun mapToDomain(type: TurnEntity): Turn {
        return Turn(TurnEnd.values()[type.turnEnd],
                getTableStatus(type.tableStatus),
                type.isFoul,
                type.isSeriousFoul,
                advStatsMapper.mapToDomain(type.advStats))
    }

    override fun mapToEntity(type: ITurn): TurnEntity {
        return TurnEntity(type.turnEnd.ordinal,
                type.gameType.ordinal,
                getStringForm(type),
                type.isFoul,
                type.isSeriousFoul,
                advStatsMapper.mapToEntity(type.advStats),
                type.advStats.player)
    }


    private companion object {
        fun getStringForm(table: ITableStatus): String {
            var tableStatus = Integer.toString(table.gameType.ordinal) + ","
            val ball = 1
            while (ball <= table.size()) {
                tableStatus += Integer.toString(table.getBallStatus(ball).ordinal)

                if (ball != table.size())
                    tableStatus += ","
            }

            return tableStatus
        }

        fun getTableStatus(table: String): ITableStatus {
            val ballStatuses = StringUtils.splitByWholeSeparator(table, ",")
            val tableStatus = TableStatus.newTable(GameType.values()[Integer.valueOf(ballStatuses[0])])

            var ball = 1
            while (ball < ballStatuses.size) {
                tableStatus.setBallTo(BallStatus.values()[Integer.valueOf(ballStatuses[ball])], ball++)
            }

            return tableStatus
        }
    }
}