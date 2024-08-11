package com.tes.androidtessuitmedia.domain

import com.tes.androidtessuitmedia.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke() = userRepository.getAllUsers()
}