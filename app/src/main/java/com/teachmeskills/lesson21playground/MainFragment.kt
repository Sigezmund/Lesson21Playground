package com.teachmeskills.lesson21playground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.teachmeskills.lesson21playground.camera.CameraSampleFragment
import com.teachmeskills.lesson21playground.databinding.FragmentMainBinding
import com.teachmeskills.lesson21playground.dialer.DialerSampleFragment

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

            openCameraSample.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.action_bar_container, CameraSampleFragment.newInstance())
                    .commit()
            }

            openCallSample.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.action_bar_container, DialerSampleFragment.newInstance())
                    .commit()
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}