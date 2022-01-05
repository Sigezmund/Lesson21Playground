package com.teachmeskills.lesson21playground.dialer

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.teachmeskills.lesson21playground.R
import com.teachmeskills.lesson21playground.databinding.FragmentDialerBinding

class DialerSampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialer, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        FragmentDialerBinding.bind(requireView()).apply {
            actionCall.setOnClickListener {
                val number = phoneNumber.text
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DialerSampleFragment()
    }
}