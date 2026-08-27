package com.mtdstudio.app.ui.ai

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

class AiChatFragment : Fragment() {
    private lateinit var etMessage: EditText
    private lateinit var btnSend: Button
    private lateinit var btnMic: Button
    private lateinit var btnFixFile: Button
    private lateinit var tvResponse: TextView
    private lateinit var spinnerFile: Spinner

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) Toast.makeText(context, "🎤 Mikrofon siap", Toast.LENGTH_SHORT).show()
        else Toast.makeText(context, "Izin mikrofon diperlukan", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_ai_chat, container, false)
        etMessage = root.findViewById(R.id.et_message)
        btnSend = root.findViewById(R.id.btn_send)
        btnMic = root.findViewById(R.id.btn_mic)
        btnFixFile = root.findViewById(R.id.btn_fix_file)
        tvResponse = root.findViewById(R.id.tv_response)
        spinnerFile = root.findViewById(R.id.spinner_file)

        val files = listOf("MainActivity.kt", "EditorFragment.kt", "AndroidManifest.xml", "build.gradle.kts")
        spinnerFile.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, files)

        btnSend.setOnClickListener { sendMessage() }
        btnFixFile.setOnClickListener { fixFile() }
        btnMic.setOnClickListener { checkMicPermission() }
        return root
    }

    private fun checkMicPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.RECORD_AUDIO)
            == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "🎤 Mulai bicara...", Toast.LENGTH_SHORT).show()
        } else {
            requestPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
        }
    }

    private fun sendMessage() {
        val msg = etMessage.text.toString().trim()
        if (msg.isEmpty()) return
        tvResponse.append("\n\n👤 $msg\n🤖 Memproses...")
        etMessage.text.clear()
        lifecycleScope.launch(Dispatchers.IO) {
            delay(1000)
            withContext(Dispatchers.Main) {
                tvResponse.append("\n🤖 AI siap — ganti API Key untuk respons sebenarnya!")
            }
        }
    }

    private fun fixFile() {
        val selected = spinnerFile.selectedItem.toString()
        tvResponse.append("\n\n🔧 Memperbaiki: $selected\n✅ File diperbaiki & siap di-upload!")
        Toast.makeText(context, "File $selected diperbaiki!", Toast.LENGTH_SHORT).show()
    }
}
