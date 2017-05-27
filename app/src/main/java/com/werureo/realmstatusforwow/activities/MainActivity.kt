package com.werureo.realmstatusforwow.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.werureo.realmstatusforwow.R
import com.werureo.realmstatusforwow.adapters.RealmsAdapter
import com.werureo.realmstatusforwow.services.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        RetrofitClient.getRealms {
            rv.adapter = RealmsAdapter(it)
        }
    }

}
