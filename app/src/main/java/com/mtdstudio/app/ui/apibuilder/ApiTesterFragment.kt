package com.mtdstudio.app.ui.apibuilder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class ApiTesterFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_api_tester, container, false)
        val methods = listOf("GET", "POST", "PUT", "DELETE", "PATCH")
        val spinner = root.findViewById<Spinner>(R.id.spinner_method)
        spinner.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, methods)

        root.findViewById<Button>(R.id.btn_send).setOnClickListener {
            Toast.makeText(context, "Request dikirim!", Toast.LENGTH_SHORT).show()
        }
        return root
    }
}
