package com.brookmanholmes.bma.data.entity.mapper

/**
 * Created by brookman on 9/16/17.
 * Interface for model mappers. It provides helper methods that facilitate retrieving of models from
 * outer data source layers
 */
interface Mapper<Entity, Domain> {
    fun mapFromEntity(type: Entity): Domain

    fun mapToEntity(type: Domain): Entity
}