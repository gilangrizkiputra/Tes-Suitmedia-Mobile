package com.tes.androidtessuitmedia.repository

import com.tes.androidtessuitmedia.data.remote.response.User
import com.tes.androidtessuitmedia.data.remote.retrofit.ApiService
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllUsers(): List<User> {
        val allUsers = mutableListOf<User>()
        var currentPage = 1
        var totalPages: Int

        do {
            val response = apiService.getUsers(page = currentPage)
            if (response.isSuccessful){
                val userResponse = response.body()
                totalPages = userResponse?.total_pages ?: 0
                allUsers.addAll(userResponse?.data ?: emptyList())
                currentPage++
            }else{
                break
            }
        } while (currentPage <= totalPages)

        return allUsers
    }
}
