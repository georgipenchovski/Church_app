package com.example.ux_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SceneDetailActivity : AppCompatActivity() {

    private lateinit var scene: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_detail)

        // Get the scene data passed from the MainActivity
        scene = intent.getSerializableExtra("scene") as Scene

        val sceneTitle: TextView = findViewById(R.id.textViewSceneTitle)
        val sceneDescription: TextView = findViewById(R.id.textViewDescription)
        val sceneImage: ImageView = findViewById(R.id.imageViewSceneDetail)
        val btnShare: Button = findViewById(R.id.btnShareScene)

        sceneTitle.text = scene.title
        sceneDescription.text = scene.description

        Glide.with(sceneImage.context)
            .load(scene.imageUrl)
            .into(sceneImage)

        btnShare.setOnClickListener {
            shareScene()
        }
    }

    private fun shareScene() {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "${scene.title}\n\n${scene.description}")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share scene via"))
    }
}
