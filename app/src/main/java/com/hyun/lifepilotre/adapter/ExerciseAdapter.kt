package com.hyun.lifepilotre.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hyun.lifepilotre.R
import com.hyun.lifepilotre.data.model.Exercise

class ExerciseAdapter(private val exerciseList: ArrayList<Exercise>) : RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exercise_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(exerciseList[position])
    }

    override fun getItemCount(): Int {
        return exerciseList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(exercise: Exercise) {
            itemView.findViewById<TextView>(R.id.tv_favorite_exercise).text = exercise.name

            Log.d("ExerciseName", exercise.name)
        }
    }
}