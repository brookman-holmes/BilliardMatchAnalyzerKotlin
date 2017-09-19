package com.brookmanholmes.bma.presentation.mapper

/**
 * Created by brookman on 9/16/17.
 * Interface for model mappers. It provides helper methods that facilitate retrieving of models from
 * outer data source layers
 */
interface Mapper<ViewModel, Domain> {
    fun mapToViewModel(model: Domain): ViewModel

    fun mapToDomain(model: ViewModel): Domain
}