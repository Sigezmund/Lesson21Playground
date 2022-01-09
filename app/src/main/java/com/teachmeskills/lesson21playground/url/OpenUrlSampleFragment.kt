package com.teachmeskills.lesson21playground.url

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.teachmeskills.lesson21playground.R
import com.teachmeskills.lesson21playground.databinding.FragmentOpenUrlSampleBinding

class OpenUrlSampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_open_url_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentOpenUrlSampleBinding.bind(view).apply {
            this.openUrl.setOnClickListener {
                try {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com")))
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(context, "Something got wrong...", Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = OpenUrlSampleFragment()
    }
}