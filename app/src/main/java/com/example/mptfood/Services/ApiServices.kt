package com.example.food.services

import com.example.mptfood.Models.*
import com.google.android.gms.common.internal.safeparcel.SafeParcelable
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {
    @GET("Products")
    fun fetchAllProducts() : Call<List<ItemOfList>>

    @GET("clients/search/{Email}")
    fun getByEmail(@Path("Email") Email : String) : Call<Client>

    @POST("clients")
    fun addClient(@Body newClient : Client) : Call<Client>

    @GET("orders/search/{client_id}")
    fun fetchAllOrders(@Path("client_id") client_id : Int) : Call<List<Order>>

    @POST("orders")
    fun addOrder(@Body newOrder : Order) : Call<Order>

    @GET("users")
    fun fetchAllUsers() : Call<List<Client>>

    @POST("OrderContents")
    fun addOrderProduct(@Body newOrderProd : OrderContent) : Call <OrderContent>

    @GET("OrderContents/search/{order_id}")
    fun getOrderProductByOrder(@Path("order_id") order_id : Int) : Call<List<OrderContent>>

    @GET("Products/{id}")
    fun getProductById(@Path("id") id : Int) : Call<ItemOfList>

}