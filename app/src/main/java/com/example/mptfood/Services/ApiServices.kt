package com.example.food.services

import com.example.mptfood.Models.*
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {
    @GET("Products")
    fun fetchAllProducts() : Call<List<ItemOfList>>



    //@POST("orders/add")
    //fun addOrder(@Body newOrder : ItemOfOrders) : Call<ItemOfOrders>


    //@PUT("users/{id_User}")
    //fun updateUser(
          //  @Path("id_User") id: Int?,
           // @Body updateUser: ItemOfUserLogin
   //) : Call<ItemOfUserLogin>

}