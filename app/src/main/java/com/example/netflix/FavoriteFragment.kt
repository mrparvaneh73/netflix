package com.example.netflix

import android.annotation.SuppressLint
import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private val appviewmodel: Appviewmodel by activityViewModels()
    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nav: FavoriteFragmentArgs by navArgs()

//        var j = appviewmodel.favoritelist
//        for (i in j.indices) {
//            if (j[i] == 1) {
//                when (i) {
//                    0 -> {
//                        img_a.visibility = View.VISIBLE
//                        img_a.setImageResource(R.drawable.a)
//                    }
//                    1 -> {
//                        img_b.visibility = View.VISIBLE
//                        img_b.setImageResource(R.drawable.b)
//                    }
//                    2 -> {
//                        img_c.visibility = View.VISIBLE
//                        img_c.setImageResource(R.drawable.c)
//                    }
//                    3 -> {
//                        img_d.visibility = View.VISIBLE
//                        img_d.setImageResource(R.drawable.d)
//                    }
//                    4 -> {
//                        img_e.visibility = View.VISIBLE
//                        img_e.setImageResource(R.drawable.e)
//                    }
//                    5 -> {
//                        img_f.visibility = View.VISIBLE
//                        img_f.setImageResource(R.drawable.f)
//                    }
//                    6 -> {
//                        img_g.visibility = View.VISIBLE
//                        img_g.setImageResource(R.drawable.g)
//                    }
//                    7 -> {
//                        img_h.visibility = View.VISIBLE
//                        img_h.setImageResource(R.drawable.h)
//                    }
//                    8 -> {
//                        img_i.visibility = View.VISIBLE
//                        img_i.setImageResource(R.drawable.i)
//                    }
//                    9 -> {
//                        img_j.visibility = View.VISIBLE
//                        img_j.setImageResource(R.drawable.j)
//                    }
//                    10 -> {
//                        img_k.visibility = View.VISIBLE
//                        img_k.setImageResource(R.drawable.k)
//                    }
//                    11 -> {
//                        img_l.visibility = View.VISIBLE
//                        img_l.setImageResource(R.drawable.l)
//                    }
//                    12 -> {
//                        img_m.visibility = View.VISIBLE
//                        img_m.setImageResource(R.drawable.m)
//                    }
//                    13 -> {
//                        img_n.visibility = View.VISIBLE
//                        img_n.setImageResource(R.drawable.n)
//                    }
//                    14 -> {
//                        img_o.visibility = View.VISIBLE
//                        img_o.setImageResource(R.drawable.o)
//                    }
//                    15 -> {
//                        img_p.visibility = View.VISIBLE
//                        img_p.setImageResource(R.drawable.p)
//                    }
//                    16 -> {
//                        img_q.visibility = View.VISIBLE
//                        img_q.setImageResource(R.drawable.q)
//                    }
//                    18 -> {
//                        img_r.visibility = View.VISIBLE
//                        img_r.setImageResource(R.drawable.r)
//                    }
//                    19 -> {
//                        img_s.visibility = View.VISIBLE
//                        img_s.setImageResource(R.drawable.s)
//                    }
//                    20 -> {
//                        img_t.visibility = View.VISIBLE
//                        img_t.setImageResource(R.drawable.t)
//                    }
//                    21 -> {
//                        img_u.visibility = View.VISIBLE
//                        img_u.setImageResource(R.drawable.u)
//                    }
//                }
//            }
//        }

    }
}


