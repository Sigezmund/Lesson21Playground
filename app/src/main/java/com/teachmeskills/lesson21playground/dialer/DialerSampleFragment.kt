package com.teachmeskills.lesson21playground.dialer

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.teachmeskills.lesson21playground.R
import com.teachmeskills.lesson21playground.databinding.FragmentDialerBinding

class DialerSampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentDialerBinding.bind(view).apply {
            this.actionCall.setOnClickListener {
                try {
                    val number = phoneNumber.text
                    startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")))
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(context, "Something got wrong...", Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DialerSampleFragment()
    }
}