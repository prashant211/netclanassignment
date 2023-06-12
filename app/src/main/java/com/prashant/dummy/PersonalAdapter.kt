package com.prashant.dummy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PersonalAdapter(val context: Context, private val itemList: ArrayList<Info>): RecyclerView.Adapter<PersonalAdapter.HomeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.personal_single_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(p0: HomeViewHolder, p1: Int) {

        val Info = itemList[p1]
        p0.bind(Info)
    }
        class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            private val name: TextView = view.findViewById(R.id.PersonName)!!
            private val about: TextView = view.findViewById(R.id.About)!!
            private val distance: TextView = view.findViewById(R.id.distance)!!
            private val hobbies: TextView = view.findViewById(R.id.hobbies)!!
            private val information: TextView = view.findViewById(R.id.information)!!
            private val info: TextView = view.findViewById(R.id.Short)!!
            private val content: LinearLayout = view.findViewById(R.id.content)!!


            fun bind(info: Info) {
                name.text = info.PersonName
                about.text = info.about
                distance.text = info.distance
                hobbies.text = info.hobbies
                information.text = info.info
                this.info.text = info.short
            }
        }

    }

