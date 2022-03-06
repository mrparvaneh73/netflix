package com.example.netflix

import android.graphics.Color
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("android:favorite")
fun ImageView.image( favorite:Boolean){
    if (favorite==true){
        this.setImageResource(R.drawable.heartbuttom_red)
    }else{
        this.setImageResource(R.drawable.heartbuttom_white)
    }

}

