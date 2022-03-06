package com.example.netflix

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.toColor
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var recyclerView: RecyclerView
    lateinit var binding: FragmentHomeBinding
    private val viewmodel  by activityViewModels<Appviewmodel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = GridLayoutManager(view.context, 3)
        val adapter = Myadapter(viewmodel.moviesArrayList){
            it.isliked= it.isliked.not()
            if (it.isliked==false){
                it.movielikebuttom=R.drawable.heartbuttom_white
            }else{
                it.movielikebuttom=R.drawable.heartbuttom_red
            }

            recyclerView.adapter?.notifyDataSetChanged()
        }
//        recyclerView.adapter?.notifyDataSetChanged()
        recyclerView.adapter = adapter
    }




}
