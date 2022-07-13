package com.rungene.android.notekeeper

import android.R
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.rungene.android.notekeeper.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/


        val adapterCourses = context?.let {
            ArrayAdapter<CourseInfo>(
                it,
                R.layout.simple_spinner_dropdown_item,
                DataManager.courses.values.toList())
        }

      binding.spinnerCourses.adapter =adapterCourses

        val bundle = arguments
        if (bundle == null) {
            Log.e("Confirmation", "FirstFragment did not receive data information")
            return
        }

        // Retrieve passed arguments and display them
        val args = FirstFragmentArgs.fromBundle(bundle)
        showDataInfo(args.dataInfo)
        
    }

    private fun showDataInfo(dataInfo: NoteInfo) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}