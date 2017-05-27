package com.werureo.realmstatusforwow.services

import android.util.Log
import com.werureo.realmstatusforwow.models.Realm
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient
{
    val BASE_URL = "https://us.api.battle.net"

    private fun getRetrofitInstance() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun getApiService() = getRetrofitInstance().create(BattleNetService::class.java)

    fun getRealms(completion: (List<Realm>?) -> Unit)
    {
        val call = getApiService().requestRealms()
        call.enqueue(object: Callback<List<Realm>>
        {
            override fun onResponse(call: Call<List<Realm>>?, response: Response<List<Realm>>?)
            {
                val repos = response?.body()
                Log.v("RetrofitClient", repos.toString())
                completion(repos)
            }

            override fun onFailure(call: Call<List<Realm>>?, t: Throwable?)
            {
                Log.v("RetrofitClient", "Call failed: ${t.toString()}")
            }
        })
    }
}