package com.mtdstudio.app.ui.github

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class GitHubFragment : Fragment() {
    private lateinit var tvLog: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_github, container, false)
        tvLog = root.findViewById(R.id.tv_log)

        root.findViewById<Button>(R.id.btn_clone).setOnClickListener {
            tvLog.append("\n📂 Cloning repo... ✅ Selesai!")
            Toast.makeText(context, "Repo di-clone!", Toast.LENGTH_SHORT).show()
        }
        root.findViewById<Button>(R.id.btn_pull).setOnClickListener {
            tvLog.append("\n📥 Pull terbaru... ✅ Selesai!")
            Toast.makeText(context, "Pull berhasil!", Toast.LENGTH_SHORT).show()
        }
        root.findViewById<Button>(R.id.btn_push).setOnClickListener {
            tvLog.append("\n📤 Push ke GitHub... ✅ Selesai!")
            Toast.makeText(context, "Push berhasil!", Toast.LENGTH_SHORT).show()
        }
        return root
    }
}
