package com.brookmanholmes.bma.data.entity.mapper

import com.brookmanholmes.bma.data.entity.AdvStatsEntity
import com.brookmanholmes.bma.data.entity.decodeEnumSet
import com.brookmanholmes.bma.data.entity.encodeEnumSet
import com.brookmanholmes.bma.domain.model.turn.AdvStats

/**
 * Created by brookman on 9/17/17.
 */
class AdvStatsMapper : Mapper<AdvStatsEntity, AdvStats> {
    override fun mapToDomain(type: AdvStatsEntity): AdvStats {
        return AdvStats.Builder(type.player)
                .cueing(type.cueX, type.cueY)
                .howTypes(decodeEnumSet(type.howTypes, AdvStats.HowType::class.java))
                .angle(decodeEnumSet(type.angles, AdvStats.Angle::class.java))
                .cbDistance(type.cbToOb)
                .obDistance(type.obToAimPoint)
                .shotType(AdvStats.ShotType.values()[type.shotType])
                .speed(type.speed)
                .subType(AdvStats.SubType.values()[type.shotSubType])
                .build()
    }

    override fun mapToEntity(type: AdvStats): AdvStatsEntity {
        return AdvStatsEntity(type.shotType.ordinal,
                type.shotSubtype.ordinal,
                encodeEnumSet(type.howTypes),
                encodeEnumSet(type.angles),
                type.cbToOb,
                type.obToPocket,
                type.speed,
                type.cueX,
                type.cueY,
                type.player)
    }
}