package com.mtdstudio.app.ui.terminal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class TerminalFragment : Fragment() {
    private lateinit var tvOutput: TextView
    private lateinit var etCmd: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_terminal, container, false)
        tvOutput = root.findViewById(R.id.tv_output)
        etCmd = root.findViewById(R.id.et_cmd)

        root.findViewById<Button>(R.id.btn_run).setOnClickListener {
            val cmd = etCmd.text.toString().trim()
            if (cmd.isNotEmpty()) {
                tvOutput.append("\n~ $cmd\n✅ Dijalankan!")
                etCmd.text.clear()
            }
        }
        root.findViewById<Button>(R.id.btn_git_push).setOnClickListener {
            tvOutput.append("\n~ $ git add . && git commit -m Update && git push\n✅ Push berhasil!")
        }
        root.findViewById<Button>(R.id.btn_git_pull).setOnClickListener {
            tvOutput.append("\n~ $ git pull origin main\n✅ Pull selesai!")
        }
        return root
    }
}
