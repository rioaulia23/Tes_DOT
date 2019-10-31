package com.example.tes_dot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.e
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tes_dot.adapters.MainAdapter
import com.example.tes_dot.models.ModelData
import com.example.tes_dot.models.ModelJSON
import com.example.tes_dot.utils.ApiClient
import com.example.tes_dot.utils.ApiInterface
import kotlinx.android.synthetic.main.home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        rcview.layoutManager = LinearLayoutManager(this)
        rcview.adapter
        getData()
    }

    fun getData() {
        val apiInterface = ApiClient().getClient().create(ApiInterface::class.java)
        apiInterface.getData().enqueue(object : Callback<ModelJSON> {
            override fun onResponse(
                call: Call<ModelJSON>,
                response: Response<ModelJSON>
            ) {
                if (response.code() == 200) {
                    rcview.adapter = MainAdapter(this@MainActivity, response.body()!!.data)
                } else {
                    Toast.makeText(this@MainActivity, "Kesalahan server", Toast.LENGTH_LONG).show()
                    e("error", "Kesalahan server")
                }
            }

            override fun onFailure(call: Call<ModelJSON>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG).show()
            }
        })
    }
}
