package com.example.ux_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SceneAdapter(private val scenes: List<Scene>) : RecyclerView.Adapter<SceneAdapter.SceneViewHolder>() {

    lateinit var context: Context
    private var listener: ((Scene) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SceneViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.scene_item, parent, false)
        return SceneViewHolder(view)
    }

    override fun onBindViewHolder(holder: SceneViewHolder, position: Int) {
        val scene = scenes[position]
        holder.titleTextView.text = scene.title
        // Load image into imageView using Glide or Picasso
        Glide.with(holder.imageView.context)
            .load(scene.imageUrl)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            listener?.invoke(scene)
            Toast.makeText(context, "Hi" + scene.title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = scenes.size

    fun setOnItemClickListener(listener: (Scene) -> Unit) {
        this.listener = listener
    }

    class SceneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        val imageView: ImageView = itemView.findViewById(R.id.imageViewSceneDetail)
    }
}