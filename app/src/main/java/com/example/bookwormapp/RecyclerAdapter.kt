package com.example.bookwormapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bookwormapp.modelResponse.Bookdata

class RecyclerAdapter(val context:Context, val arrBooksdata:ArrayList<Bookdata>) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {


    //view holder
    class RecyclerViewHolder(view:View): RecyclerView.ViewHolder(view) {
        val txtBookname: TextView = view.findViewById(R.id.txtBookname)
        val txtBookauthor: TextView = view.findViewById(R.id.txtBookauthor)
        val txtBookprice: TextView = view.findViewById(R.id.txtBookprice)
        val txtBookrating: TextView = view.findViewById(R.id.txtBookrating)
        val imgBook: ImageView = view.findViewById(R.id.imgBook)
        val LLrecycler_row: LinearLayout = view.findViewById(R.id.LLrecycler_row)

    }

    //for creating initial 10 views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrBooksdata.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {

        holder.txtBookname.text = arrBooksdata[position].bookName
        holder.txtBookauthor.text = arrBooksdata[position].bookAuthor
        holder.txtBookprice.text = arrBooksdata[position].bookPrice
        holder.txtBookrating.text = arrBooksdata[position].bookRating
        holder.imgBook.setImageResource(arrBooksdata[position].bookImage)
        holder.LLrecycler_row.setOnClickListener{
            Toast.makeText(context,"Clicked on ${holder.txtBookname.text}",Toast.LENGTH_SHORT).show()
        }
    }

}