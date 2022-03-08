package com.example.netflix.model

import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider

data class Movies(var movieimage:Int,var moviename:String,var movielikebuttom:Int,var isliked:Boolean){
}