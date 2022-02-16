package com.example.netflix

import android.app.Notification.EXTRA_TEXT
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_comingsoon.*
import java.net.URI

class ComingSoonFragment:Fragment(R.layout.fragment_comingsoon), View.OnClickListener {
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listcomingsoon= mutableListOf<ImageView>(
            comingsoon_a,comingsoon_b,comingsoon_c,comingsoon_d)
        for (i in listcomingsoon){
            i.setOnClickListener(this)
        }
            activityResultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
                ActivityResultCallback {  })

    }


    override fun onClick(v: View?) {
        val comingsoon=view?.findViewById<ImageView>(v!!.id)
        val intent=Intent()
        intent.setAction(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_STREAM,comingsoon.toString())
      intent.setType("text/plain")
        activityResultLauncher.launch(intent)

    }


}