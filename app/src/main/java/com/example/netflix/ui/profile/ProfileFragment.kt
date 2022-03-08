package com.example.netflix.ui.profile
import android.app.AlertDialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.netflix.ui.Appviewmodel
import com.example.netflix.R
import com.example.netflix.data.NetworkManager.service
import com.example.netflix.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream


class ProfileFragment:Fragment(R.layout.fragment_profile) {
    fun Bitmap.toByteArray():ByteArray{
        ByteArrayOutputStream().apply {
            compress(Bitmap.CompressFormat.JPEG,10,this)
            return toByteArray()
        }
    }

    var imageBitmap:ByteArray? = null
    private val appviewmodel: Appviewmodel by activityViewModels()
    lateinit var binding: FragmentProfileBinding

  private  val cameraluncher=registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()) {
            imageBitmap=it.toByteArray()
            profile_image.setImageBitmap(it)
    }
    private val  selectPictureLuncher=registerForActivityResult(ActivityResultContracts.GetContent(),{
        val change=context?.contentResolver?.openInputStream(it)?.readBytes()
        imageBitmap=change
        profile_image.setImageURI(it)
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentProfileBinding.inflate(layoutInflater, container ,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profile_image.setOnClickListener {
           val builder=AlertDialog.Builder(requireContext())
            builder.setTitle("Selectimage")
            builder.setMessage("Choose your Option:")
            builder.setPositiveButton("Gallery", { dialog, which ->
                    dialog.dismiss()
                selectPictureLuncher.launch("image/*")


            })
            builder.setNegativeButton("Cammera", { dialog, which ->
                dialog.dismiss()
                cameraluncher.launch(null)

            })
            builder.create().show()


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
            }else{
                val imageName = binding.fullname.editText?.text.toString()
                val body = MultipartBody.create(MediaType.parse("image/*"), imageBitmap)
                val request = MultipartBody.Part.createFormData("image", "$imageName.jpg", body)
                service.sendImage(imageName, request).enqueue(object : Callback<Any> {
                    override fun onResponse(call: Call<Any>, response: Response<Any>) {
                        Toast.makeText(requireContext(), "Your Image uploaded successfully", Toast.LENGTH_SHORT).show()
                    }
                    override fun onFailure(call: Call<Any>, t: Throwable) {
                        Toast.makeText(requireContext(), "Oops something Went wrong", Toast.LENGTH_SHORT).show()
                    }
                })
            }

        }
        btngetimage.setOnClickListener {
            val imageName = binding.fullname.editText?.text.toString()
            val call = service.getImage("$imageName.jpg")
            call.enqueue(object : Callback<ResponseBody?> {
                override fun onResponse(
                    call: Call<ResponseBody?>,
                    response: Response<ResponseBody?>
                ) {
                    val bmp:Bitmap = BitmapFactory.decodeStream(response.body()?.byteStream())
                    profile_image.setImageBitmap(bmp)
                }

                override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                    Toast.makeText(requireContext(), "Not Found", Toast.LENGTH_SHORT).show()
                }
            })
        }

    }





}
