package com.example.netflix

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix.databinding.ListItemBinding

class Myadapter(private var movielist: ArrayList<Movies> , private var clickListener:(Movies) -> Unit) :
    RecyclerView.Adapter<Myadapter.MyViewHolder>() {

    class MyViewHolder(itemView: View,clickposition: (Int) ->Unit) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movie_image)
        val movieName: TextView = itemView.findViewById(R.id.movie_name)
        var movielike:ImageButton=itemView.findViewById(R.id.movie_like_buttom)
        var binding: ListItemBinding = DataBindingUtil.bind(itemView)!!
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