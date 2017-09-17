package com.brookmanholmes.scaffold.presentation.mapper

/**
 * Created by brookman on 9/16/17.
 * Interface for model mappers. It provides helper methods that facilitate retrieving of models from
 * outer data source layers
 */
interface Mapper<Presentation, Domain> {
    fun mapFromDomain(model: Domain): Presentation

    fun mapToDomain(model: Presentation): Domain
}