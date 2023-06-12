package com.prashant.dummy

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Personal : Fragment() {
    lateinit var recyclerview:RecyclerView
    lateinit var layoutmanager:RecyclerView.LayoutManager
    lateinit var recyclerAdapter:PersonalAdapter

    val InfoList= arrayListOf<Info>(
        Info("Prashant Patel","Ajmer|student","within 2.8KM","Business|Friendship|Coffee","Hi community! I am open to new connections","PP"),
        Info("Durganshu Mishra","Ajmer|student","within 10.8KM","Friendship|Coffee","Hi community! I am open to new connections,an optimistic student,an optimistic person who loves to learn and explore new things","DM"),
        Info("Ashish Kumar Sharma","vadodra|student","within 103.8KM","Dating|Friendship|Coffee","Hi community! I am open to new connections","AS"),
        Info("Akhilesh Yadav","Amritsar|student","within 200.8KM","Friendship|Business","Hi community! I am open to new connections","AY"),
        Info("Dheeraj shahu","Delhi|student","within 130.8KM","Dating|Coffee","Hi community! I am open to new connections","DS"),
        Info("Ronak Sen","Kota|student","within 5.8KM","Business|friendship","Hi community! I am open to new connections","RS")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         val view= inflater.inflate(R.layout.fragment_personal, container, false)

        recyclerview=view.findViewById(R.id.recyclerView)
        layoutmanager=LinearLayoutManager(activity)
        recyclerAdapter= PersonalAdapter(activity as Context  , InfoList)
        recyclerview.adapter=recyclerAdapter
        recyclerview.layoutManager=layoutmanager
        recyclerview.addItemDecoration(DividerItemDecoration(recyclerview.context,(layoutmanager as  LinearLayoutManager).orientation))

        return view
    }
}