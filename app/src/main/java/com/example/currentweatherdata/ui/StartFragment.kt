package com.example.currentweatherdata.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.currentweatherdata.R
import com.example.currentweatherdata.databinding.FragmentStartBinding

// TODO: Saca data binding
class StartFragment : Fragment() {

    // TODO: Revisar View Binding
    private var binding: FragmentStartBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragment = this
    }

    fun goToTemperatureFragment() {
        findNavController().navigate(R.id.action_startFragment_to_temperatureFragment)
    }

    fun goToWindFragment() {
        findNavController().navigate(R.id.action_startFragment_to_windFragment)
    }

       /* val temperatureButton = view.findViewById<Button>(R.id.temperature_button)
        temperatureButton.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_temperatureFragment)
        }
       val windButton = view.findViewById<Button>(R.id.wind_button)
        windButton.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_windFragment)
        }*/


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

