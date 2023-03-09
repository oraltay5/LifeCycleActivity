package com.example.lifecycleactivity.network

//data class ProductDTO (
//    val id: Int,
//    val title: String,
//    val description: String,
//    val images: List<String>
//        )

data class ProductDTO (
    val id: Int,
    val title: String,
    val newsSite: String,
    val imageUrl: String
)

//data class ProductDTO (
//val data: List<AnimeDTO>
//)
//
//data class AnimeDTO(
//    val id: String,
//    val type: String,
//    val attributes: AnimeAttributeDTO
//)
//
//data class AnimeAttributeDTO(
//    val slug: String,
//    val description: String,
//    val averageRating: String,
//    val posterImage: AnimePosterImageDTO
//)
//
//data class AnimePosterImageDTO(
//    val medium: String,
//    val original: String,
//)