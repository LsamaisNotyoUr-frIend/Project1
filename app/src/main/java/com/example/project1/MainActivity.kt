package com.example.project1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val gitLink = "https://github.com/LsamaisNotyoUr-frIend/Project1"
    private val devLink = "https://hng.tech/hire/kotlin-developers"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button1 = binding.btnGithubBut
        val button2 = binding.btnGithubBut2

        button1.setOnClickListener {
            openRepo()
        }

        button2.setOnClickListener {
            goToDevs()
        }
    }
    private fun openRepo(){
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(gitLink)
            addCategory(Intent.CATEGORY_BROWSABLE)
        }
        startActivity(intent)
    }

    private fun goToDevs(){
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(devLink)
            addCategory(Intent.CATEGORY_BROWSABLE)
        }
        startActivity(intent)
    }
}