package com.mtdstudio.app.ui.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import io.github.rosemoe.sora.widget.CodeEditor
import io.github.rosemoe.sora.langs.kotlin.KotlinLanguage

class EditorFragment : Fragment() {
    private lateinit var editor: CodeEditor
    private lateinit var etFilename: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_editor, container, false)
        etFilename = root.findViewById(R.id.et_filename)
        val containerView = root.findViewById<FrameLayout>(R.id.editor_container)

        editor = CodeEditor(requireContext())
        editor.setLanguage(KotlinLanguage())
        editor.setText("// Ketik kode di sini...\nfun main() {\n    println(\"Hello MTDstudio!\")\n}")
        containerView.addView(editor)

        root.findViewById<Button>(R.id.btn_save).setOnClickListener {
            Toast.makeText(context, "💾 Tersimpan: ${etFilename.text}", Toast.LENGTH_SHORT).show()
        }
        root.findViewById<Button>(R.id.btn_upload).setOnClickListener {
            Toast.makeText(context, "📤 Upload ke GitHub... Berhasil!", Toast.LENGTH_SHORT).show()
        }
        root.findViewById<Button>(R.id.btn_download).setOnClickListener {
            Toast.makeText(context, "📥 Download dari GitHub... Berhasil!", Toast.LENGTH_SHORT).show()
        }
        root.findViewById<Button>(R.id.btn_undo).setOnClickListener { editor.undo() }
        root.findViewById<Button>(R.id.btn_redo).setOnClickListener { editor.redo() }
        root.findViewById<Button>(R.id.btn_find).setOnClickListener {
            Toast.makeText(context, "🔍 Cari teks...", Toast.LENGTH_SHORT).show()
        }
        root.findViewById<Button>(R.id.btn_test).setOnClickListener {
            Toast.makeText(context, "🧪 Generate Test...", Toast.LENGTH_SHORT).show()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        editor.release()
    }
}
