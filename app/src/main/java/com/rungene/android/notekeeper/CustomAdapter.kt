package com.rungene.android.notekeeper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.rungene.android.notekeeper.data.NoteInfo

class CustomAdapter(private val dataSet: List<NoteInfo>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View,var noteInfo: NoteInfo? = null) : RecyclerView.ViewHolder(view) {
        val tvCourse: TextView
        val tvTitle: TextView
        val tvText: TextView
        var id : Int =0
        init {
            // Define click listener for the ViewHolder's View.
            tvCourse = view.findViewById(R.id.tvCourse)
            tvTitle = view.findViewById(R.id.tvTitle)
            tvText = view.findViewById(R.id.tvText)
            view.setOnClickListener {
               noteInfo?.let {
                   val directions = FirstFragmentDirections.actionFirstFragmentToSecondFragment(id)
                   view.findNavController().navigate(directions)
               }
            }

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recyclerview_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvTitle.text = dataSet[position].title
        viewHolder.tvText.text = dataSet[position].text
        viewHolder.tvCourse.text = dataSet[position].courseTitle.toString()
        viewHolder.id = position+1
        viewHolder.noteInfo=dataSet[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
