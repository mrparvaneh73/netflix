package com.example.netflix.ui

import androidx.lifecycle.ViewModel
import com.example.netflix.R
import com.example.netflix.model.Movies

class Appviewmodel:ViewModel() {
    var isliked= mutableListOf<Boolean>()
    var movieId = mutableListOf<Int>()
    var moviename=mutableListOf<String>()
    var likebuttom=mutableListOf<Int>()
    lateinit var movies: Movies

    lateinit var moviesArrayList: ArrayList<Movies>



init {

        repeat(21){
            movieId.add(R.drawable.netflix_macos_bigsur_icon_189917)
        }
        repeat(21){
            moviename.add("movie${it+1}")
        }
        repeat(21){
            isliked.add(false)
        }

        repeat(21){
            likebuttom.add(R.drawable.heartbuttom_white)
        }
        moviesArrayList= arrayListOf()
        for (i in movieId.indices){
            movies= Movies(movieId[i],moviename[i],likebuttom[i],isliked[i])
            moviesArrayList.add(movies)
        }


}


    fun favorite():ArrayList<Movies>{
        var template= arrayListOf<Movies>()
        for (i in moviesArrayList){
            if (i.isliked==true){
                template.add(i)
            }
        }
        return template
    }



}