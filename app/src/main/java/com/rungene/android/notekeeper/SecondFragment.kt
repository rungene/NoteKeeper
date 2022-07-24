package com.rungene.android.notekeeper

import android.R
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat.getDrawable
import androidx.navigation.fragment.navArgs
import com.rungene.android.notekeeper.data.CourseInfo
import com.rungene.android.notekeeper.data.NoteInfo
import com.rungene.android.notekeeper.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SecondFragment : Fragment() {
    var i = 0
    val courses:List<CourseInfo> by lazy {
        DataManager.courses.values.toList()
    }
    var currentNoteId = 0

    private var _binding: FragmentSecondBinding? = null
   // var notePosition : Int = 0
    private val args:FirstFragmentArgs by navArgs()
    private lateinit var noteInfo: NoteInfo

    val currentNote
    get() = DataManager.notes[currentNoteId]

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        currentNoteId = args.dataInfo
        noteInfo = currentNote
        setHasOptionsMenu(true)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayNote()

    }

    private fun displayNote() {

        val adapterCourses = context?.let {
            ArrayAdapter<CourseInfo>(
                it,
                R.layout.simple_spinner_dropdown_item,
                courses
            )
        }

        binding.spinnerCourses.adapter =adapterCourses
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
        inflater.inflate(com.rungene.android.notekeeper.R.menu.menu_second_fragment, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            com.rungene.android.notekeeper.R.id.action_previous -> {
                previousNote()
                true
            }

            com.rungene.android.notekeeper.R.id.action_next -> {
                nextNote()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun previousNote() {
        --currentNoteId
        if (currentNoteId<0) currentNoteId=DataManager.notes.size-1
        noteInfo =currentNote
        displayNote()
    }


    private fun nextNote() {
       ++currentNoteId
        if (currentNoteId>=DataManager.notes.size) currentNoteId=0
        noteInfo = currentNote
        displayNote()
    }

    override fun onPause() {
        super.onPause()
        saveNote()
    }

    private fun saveNote() {
        val note = DataManager.notes[i]
        note.title = binding.noteTitle.text.toString()
        note.text = binding.noteText.text.toString()
        note.courseTitle = binding.spinnerCourses.selectedItem as CourseInfo

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}