package com.example.netflix

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment:Fragment(R.layout.fragment_profile) {
    private lateinit var activityResultLauncher: ActivityResultLauncher<Void>
    private val appviewmodel: Appviewmodel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityResultLauncher=registerForActivityResult(
            ActivityResultContracts.TakePicturePreview()
        ) {
            profile_image.setImageBitmap(it)
        }
        profile_image.setOnClickListener {
            activityResultLauncher.launch(null)
        }
        fun validateFullName():Boolean{
            return  if (fullname.editText?.text?.length==0) {
                fullname.error = "field can't be empty!!"
                false
            }else true

        }
        fun validateUserName():Boolean{
            return if (username.editText?.text?.length==0) {
                username.error = "field can't be empty!!"
                false
            }else true
        }
        fun validateEmail():Boolean{
            return    if (email.editText?.text?.length==0){
                email.error = "field can't be empty!!"
                false
            }else if (!Patterns.EMAIL_ADDRESS.matcher(email.editText?.text.toString()).matches()) {
                email.error = "unvalid email address!!"
                false
            }else true
        }
        fun validatePassword():Boolean{
            return if (password.editText?.text?.length==0) {
                password.error = "field can't be empty!!"
                false
            }else true
        }
        fun validateRetypePassword():Boolean{
            return if(repassword.editText?.text?.length==0){
                repassword.error = "field can't be empty!!"
                false
            }else if(repassword.editText?.text.toString() != password.editText?.text.toString()){
                repassword.error = "mismatch!!"
                false
            }else true
        }
        fun validateGender():Boolean{
            return if ( gender.checkedRadioButtonId == -1) {
                male.error="Select Item"
                false
            }else true
        }
        btnregister.setOnClickListener {
            if (!validateFullName() || !validateUserName() ||  !validateEmail() || !validatePassword() || !validateRetypePassword() || !validateGender()){
                return@setOnClickListener
            }else {
                appviewmodel.registred=true


            }

        }
    }
}