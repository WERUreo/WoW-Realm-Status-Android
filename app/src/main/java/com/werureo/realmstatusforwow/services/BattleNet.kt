package com.werureo.realmstatusforwow.services

import com.werureo.realmstatusforwow.models.Realm
import retrofit2.Call
import retrofit2.http.GET

interface BattleNet
{
    @GET("/wow/realm/status?locale=en_US&apikey=ynr4j4447kmrhzm4zas3aqruy5u2erdg")
    fun requestRealms(): Call<List<Realm>>
}