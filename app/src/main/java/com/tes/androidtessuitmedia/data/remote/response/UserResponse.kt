package com.tes.androidtessuitmedia.data.remote.response

data class UserResponse(
    val data: List<User>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)