package com.example.netflix

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment:Fragment(R.layout.fragment_home),View.OnClickListener {
private lateinit var heart:MutableList<ImageButton>
    private val appviewmodel: Appviewmodel by activityViewModels()
//    val nav: HomeFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
       heart= mutableListOf(heart_a,heart_b,heart_c,heart_d,heart_e,heart_f,heart_g,heart_h
           ,heart_i,heart_j,heart_k,heart_l,heart_m,heart_n,heart_o,heart_p,heart_q,heart_r,heart_s,heart_t,heart_u)
for (i in heart){
    i.setOnClickListener(this)
}

//        heart_a.setOnClickListener {
//            val extras = FragmentNavigatorExtras(movie_a to "movie_a")
//
//        }
//        tv_username.text=nav.fullname


    }
    fun changecolortored(imageButton: ImageButton){

        imageButton.setImageResource(R.drawable.heartbuttom_red)

    }
    fun changecolortowhite(imageButton: ImageButton){
        imageButton.setImageResource(R.drawable.heartbuttom_white)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(v: View?) {
        val btnheart = view?.findViewById<ImageButton>(v!!.id)
        if (appviewmodel.registred==true){
            if(appviewmodel.favoritelist[btnheart?.tag.toString().toInt()]==1) {
                appviewmodel.favoritelist[btnheart?.tag.toString().toInt()]=0
                btnheart?.let { changecolortowhite(it) }
            }else if(appviewmodel.favoritelist[btnheart?.tag.toString().toInt()]==0){
                btnheart?.let { changecolortored(it) }
                appviewmodel.favoritelist[btnheart?.tag.toString().toInt()]=1
            }
        }else{
            Toast.makeText(requireContext(), "PLEASE FIRST SIGNUP", Toast.LENGTH_SHORT).show()
//            v?.findNavController()?.navigate(R.id.action_homeFragment_to_profileFragment)
        }

        }


    }
