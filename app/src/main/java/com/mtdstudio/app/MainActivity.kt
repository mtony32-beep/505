package com.mtdstudio.app
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mtdstudio.app.ui.ai.AiChatFragment
import com.mtdstudio.app.ui.editor.EditorFragment
import com.mtdstudio.app.ui.github.GitHubFragment
import com.mtdstudio.app.ui.terminal.TerminalFragment
import com.mtdstudio.app.ui.build.BuildFragment
import com.mtdstudio.app.ui.dbviewer.DbViewerFragment
import com.mtdstudio.app.ui.apibuilder.ApiTesterFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_ai -> { supportFragmentManager.commit{ replace(R.id.fragment_container, AiChatFragment()) }; true }
                R.id.nav_editor -> { supportFragmentManager.commit{ replace(R.id.fragment_container, EditorFragment()) }; true }
                R.id.nav_github -> { supportFragmentManager.commit{ replace(R.id.fragment_container, GitHubFragment()) }; true }
                R.id.nav_terminal -> { supportFragmentManager.commit{ replace(R.id.fragment_container, TerminalFragment()) }; true }
                R.id.nav_build -> { supportFragmentManager.commit{ replace(R.id.fragment_container, BuildFragment()) }; true }
                R.id.nav_db -> { supportFragmentManager.commit{ replace(R.id.fragment_container, DbViewerFragment()) }; true }
                R.id.nav_api -> { supportFragmentManager.commit{ replace(R.id.fragment_container, ApiTesterFragment()) }; true }
                else -> false
            }
        }
        if(savedInstanceState == null) supportFragmentManager.commit{ replace(R.id.fragment_container, AiChatFragment()) }
    }
}
