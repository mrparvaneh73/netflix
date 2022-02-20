package com.example.netflix

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Myadapter(private val movielist:ArrayList<Movies>): RecyclerView.Adapter<Myadapter.MyViewHolder>() {
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val movieImage:ImageView=itemView.findViewById(R.id.movie_image)
        val movieName:TextView=itemView.findViewById(R.id.movie_name)
        val likebuttom:ImageView=itemView.findViewById(R.id.likeme)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val viewholder=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(viewholder)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=movielist[position]
        holder.movieImage.setImageResource(currentItem.movieimage)
        holder.movieName.text=currentItem.moviename
        holder.likebuttom.setImageResource(currentItem.likebuttom)
    }

    override fun getItemCount(): Int {
        return movielist.size
    }
}