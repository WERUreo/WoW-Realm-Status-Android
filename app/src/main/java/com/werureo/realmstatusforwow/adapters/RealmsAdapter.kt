package com.werureo.realmstatusforwow.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.werureo.realmstatusforwow.R
import com.werureo.realmstatusforwow.models.Realm
import kotlinx.android.synthetic.main.list_item.view.*

class RealmsAdapter(val realms: List<Realm>?) : RecyclerView.Adapter<RealmsAdapter.ViewHolder>()
{
    override fun getItemCount() = realms?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) : ViewHolder
    {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int)
    {
        holder?.bindRealm(realms?.get(position))
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    {
        fun bindRealm(realm: Realm?)
        {
            when(realm?.status)
            {
                true -> view.realm_status_view.setBackgroundResource(R.drawable.realm_online)
                false -> view.realm_status_view.setBackgroundResource(R.drawable.realm_offline)
            }

            view.realm_name_text_view.text = realm?.name
            view.realm_type_text_view.text = realm?.type.toString()
            view.realm_pop_text_view.text = realm?.population
        }
    }
}