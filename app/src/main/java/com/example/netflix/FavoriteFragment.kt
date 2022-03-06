package com.example.netflix

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding:FragmentFavoriteBinding
    private val viewmodel: Appviewmodel by activityViewModels()
    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nav: FavoriteFragmentArgs by navArgs()

        recyclerView = view.findViewById(R.id.favoriteFragment)
        recyclerView.layoutManager = GridLayoutManager(view.context, 1)

        viewmodel.favorite()
        Log.d(TAG, "onViewCreated: "+viewmodel.favorite().size)
        val adapter = Myadapter(viewmodel.favorite()){
            Toast.makeText(requireContext(),"${it.moviename}is liked" , Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter

    }
}


