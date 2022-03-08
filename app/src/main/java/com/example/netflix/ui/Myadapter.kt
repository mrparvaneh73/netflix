package com.example.netflix.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix.R
import com.example.netflix.model.Movies

class Myadapter(private var movielist: ArrayList<Movies>, private var clickListener:(Movies) -> Unit) :
    RecyclerView.Adapter<Myadapter.MyViewHolder>() {

    class MyViewHolder(itemView: View,clickposition: (Int) ->Unit) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movie_image)
        val movieName: TextView = itemView.findViewById(R.id.movie_name)
        var movielike:ImageButton=itemView.findViewById(R.id.movie_like_buttom)

        init {


                movielike.setOnClickListener {
                    clickposition(absoluteAdapterPosition)


                }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewholder = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(viewholder){
            clickListener(movielist[it])
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = movielist[position]
        holder.movieImage.setImageResource(currentItem.movieimage)
        holder.movieName.text = currentItem.moviename
        holder.movielike.setImageResource(currentItem.movielikebuttom)


    }
    override fun getItemCount(): Int = movielist.size

}