package com.brookmanholmes.bma.data.entity.mapper

import com.brookmanholmes.bma.data.entity.UserEntity
import com.brookmanholmes.bma.domain.model.UserModel

/**
 * Created by brookman on 9/17/17.
 */
class UserMapper : Mapper<UserEntity, UserModel> {
    override fun mapToDomain(type: UserEntity): UserModel {
        return UserModel(type.name, type.id, type.imageUrl)
    }

    override fun mapToEntity(type: UserModel): UserEntity {
        return UserEntity(type.name, type.id, type.imageUrl)
    }
}