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
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rungene.android.notekeeper.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    val courses:List<CourseInfo> by lazy {
        DataManager.courses.values.toList()
    }

    private var _binding: FragmentFirstBinding? = null
   // var notePosition : Int = 0
    private val args:FirstFragmentArgs by navArgs()
    private lateinit var noteInfo: NoteInfo

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        noteInfo = args.dataInfo
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapterCourses = context?.let {
            ArrayAdapter<CourseInfo>(
                it,
                R.layout.simple_spinner_dropdown_item,
                courses
              )
        }

        var index : Int ? = null
        var i = 0
        for (course:CourseInfo in courses){
            if (noteInfo.course == course.title){
                index=i
                break
            }
            i++
        }
        binding.spinnerCourses.adapter =adapterCourses
        if (index==null){
           Toast.makeText(context,"Selected note is not attached to a course",Toast.LENGTH_SHORT)
               .show()
        }else{
            binding.spinnerCourses.setSelection(index)
        }



        binding.noteTitle.setText(noteInfo.title)
        binding.noteText.setText(noteInfo.text)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}