package com.mtdstudio.app.ui.build

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class BuildFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_build, container, false)
        root.findViewById<Button>(R.id.btn_build).setOnClickListener {
            Toast.makeText(context, "🔨 Build dimulai! Buka GitHub → Actions", Toast.LENGTH_LONG).show()
        }
        root.findViewById<Button>(R.id.btn_download).setOnClickListener {
            val url = "https://github.com/mtony32-beep/505/actions"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
        return root
    }
}
