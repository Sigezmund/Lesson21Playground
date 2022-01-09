package com.teachmeskills.lesson21playground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.teachmeskills.lesson21playground.camera.CameraSampleFragment
import com.teachmeskills.lesson21playground.databinding.FragmentMainBinding
import com.teachmeskills.lesson21playground.dialer.DialerSampleFragment
import com.teachmeskills.lesson21playground.url.OpenUrlSampleFragment

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        FragmentMainBinding.bind(view).apply {

            openUrlSample.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, OpenUrlSampleFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }

            openCameraSample.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, CameraSampleFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }

            openCallSample.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, DialerSampleFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}