package com.example.lifecycleactivity.network

import retrofit2.http.GET

interface ProductAPI{
//    @GET("products/1")
    @GET("v3/articles/1")
    suspend fun getProductById(): ProductDTO
}


