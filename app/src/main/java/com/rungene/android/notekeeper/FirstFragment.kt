package com.rungene.android.notekeeper

import android.R
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.rungene.android.notekeeper.data.CourseInfo
import com.rungene.android.notekeeper.data.NoteInfo
import com.rungene.android.notekeeper.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    var i = 0
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
        setHasOptionsMenu(true)
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
        binding.spinnerCourses.adapter =adapterCourses
        displayNote()

    }

    private fun displayNote() {
        var index: Int? = null

        for (course: CourseInfo in courses) {
            if (noteInfo.courseTitle.toString() == course.title) {
                index = i
                break
            }
            i++
        }

        if (index == null) {
            Toast.makeText(context, "Selected note is not attached to a course", Toast.LENGTH_SHORT)
                .show()
        } else {
            binding.spinnerCourses.setSelection(index)
        }

        binding.noteTitle.setText(noteInfo.title)
        binding.noteText.setText(noteInfo.text)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater:MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(com.rungene.android.notekeeper.R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            com.rungene.android.notekeeper.R.id.action_settings -> true
            com.rungene.android.notekeeper.R.id.action_next -> {
                moveNext()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveNext() {
       ++i
 displayNote()
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}