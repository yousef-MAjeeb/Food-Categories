package com.example.foodcategories.data

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    //www.themealdb.com/api/json/v1/1/categories.php
    @GET("categories.php")
    fun listAll(): Call<Model>
}