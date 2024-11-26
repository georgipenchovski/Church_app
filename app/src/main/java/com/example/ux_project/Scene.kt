package com.example.ux_project

import java.io.Serializable

data class Scene(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String
) : Serializable
