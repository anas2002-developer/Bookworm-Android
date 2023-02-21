package com.example.bookwormapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookwormapp.modelResponse.Bookdata

class DashboardFragment : Fragment() {

    lateinit var vRV: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter
    var arrBooksdata = arrayListOf<Bookdata>(
        Bookdata("Python","Sumita Arora","200","4.5",R.drawable.bookworm),
        Bookdata("Java","Sumita Arora","200","4.5",R.drawable.bookworm),
        Bookdata("JavaScript","Sumita Arora","200","4.5",R.drawable.bookworm),
        Bookdata("Swift","Sumita Arora","200","4.5",R.drawable.bookworm),
        Bookdata("Flutter","Sumita Arora","200","4.5",R.drawable.bookworm),
        Bookdata("Kotlin","Sumita Arora","200","4.5",R.drawable.bookworm),
        Bookdata("C","Sumita Arora","200","4.5",R.drawable.bookworm),
        Bookdata("C++","Sumita Arora","200","4.5",R.drawable.bookworm),
        Bookdata("Html","Sumita Arora","200","4.5",R.drawable.bookworm),
        Bookdata("React","Sumita Arora","200","4.5",R.drawable.bookworm),

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_dashboard, container, false)
        vRV = view.findViewById(R.id.vRV)

        //vRV.setLayoutManager(new LinearLayoutManager(this)) java
        vRV.layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = RecyclerAdapter(activity as Context, arrBooksdata)
        vRV.adapter = recyclerAdapter

        vRV.addItemDecoration(DividerItemDecoration(vRV.context, (vRV.layoutManager as LinearLayoutManager).orientation))

        return view
    }
}