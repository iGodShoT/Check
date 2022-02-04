package com.example.mptfood

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.mptfood.Models.CartItem
import com.example.mptfood.Models.ItemOfList
import com.example.mptfood.Models.ShoppingCart
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    var num : Int = 1

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val product = intent.getParcelableExtra<ItemOfList>("OBJECT_INTENT")
        val title = findViewById<TextView>(R.id.ProductName)
        val description = findViewById<TextView>(R.id.ProductDescription)
        val product_img = findViewById<ImageView>(R.id.ProductImage)
        val product_price = findViewById<TextView>(R.id.Price)
        val add_button = findViewById<Button>(R.id.AddToCart)


        title.text = product?.Name
        product_price.text = product?.Price.toString()
        val imageBytes = Base64.decode(product?.Image, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        product_img.setImageBitmap(decodedImage)

        Observable.create(ObservableOnSubscribe<MutableList<CartItem>> {

            add_button.setOnClickListener { view ->

                val item = CartItem(product)
                ShoppingCart.addItem(item, num)
                Toast.makeText(this, "${product?.Name} добавлен в корзину", Toast.LENGTH_LONG).show()
                it.onNext(ShoppingCart.getCart())

            }
        }).subscribe{ cart ->
            var quantity = CartItem(product).Quantity

            cart.forEach{cartItem ->
                quantity += num
            }

        }
    }

    fun addProd(view: View){
        if (num < 99){
            num++
        }
        setText()
        countPrice()
    }

    private fun countPrice() {
        val product = intent.getParcelableExtra<ItemOfList>("OBJECT_INTENT")
        Price.setText((num * product!!.Price).toString())
    }

    fun remProd(view: View) {
        if (num > 1){
            num--
        }
        setText()
        countPrice()
    }

    private fun setText() = Quantity.setText(num.toString()+"")


}