package com.example.food.services

import com.example.mptfood.Models.*
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {
    @GET("Products")
    fun fetchAllProducts() : Call<List<ItemOfList>>

    @GET("orders")
    fun fetchAllOrders() : Call<List<Order>>

    @POST("orders")
    fun addOrder(@Body newOrder : Order) : Call<Order>

    @GET("users")
    fun fetchAllUsers() : Call<List<Client>>

    @POST("OrderContents")
    fun addOrderProduct(@Body newOrderProd : OrderContent) : Call <OrderContent>

    //@PUT("users/{id_User}")
    //fun updateUser(
          //  @Path("id_User") id: Int?,
           // @Body updateUser: ItemOfUserLogin
   //) : Call<ItemOfUserLogin>

}