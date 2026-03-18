package com.example.foodcategories.data

import retrofit2.http.GET

interface APIService {
    //www.themealdb.com/api/json/v1/1/categories.php
    @GET("categories")
    fun listAll(): List<Categoty>
}