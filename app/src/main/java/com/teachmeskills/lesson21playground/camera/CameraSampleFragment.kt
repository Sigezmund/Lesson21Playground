package com.teachmeskills.lesson21playground.camera

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.teachmeskills.lesson21playground.R
import com.teachmeskills.lesson21playground.databinding.FragmentCameraBinding

class CameraSampleFragment : Fragment() {

    private var binding: FragmentCameraBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCameraBinding.bind(view).apply {
            this.selectPhoto.setOnClickListener {
                dispatchTakePictureIntent()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            // Обязательно проверяем, что есть ли Activity, которая может обработать наш вызов
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            binding?.photo?.setImageBitmap(imageBitmap)
        }
    }

    companion object {
        private const val REQUEST_IMAGE_CAPTURE = 1

        @JvmStatic
        fun newInstance() = CameraSampleFragment()
    }
}