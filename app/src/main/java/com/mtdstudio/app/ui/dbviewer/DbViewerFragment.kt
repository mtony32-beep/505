package com.mtdstudio.app.ui.dbviewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class DbViewerFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_db_viewer, container, false)
        val tables = listOf("users", "files", "settings", "logs")
        val spinner = root.findViewById<Spinner>(R.id.spinner_table)
        spinner.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, tables)

        root.findViewById<Button>(R.id.btn_query).setOnClickListener {
            Toast.makeText(context, "Query dijalankan!", Toast.LENGTH_SHORT).show()
        }
        root.findViewById<Button>(R.id.btn_export).setOnClickListener {
            Toast.makeText(context, "Data diekspor!", Toast.LENGTH_SHORT).show()
        }
        return root
    }
}
