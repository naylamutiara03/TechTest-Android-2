package com.example.techtest_android2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StudentAdapter(private val studentList: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    // ViewHolder untuk setiap item dalam RecyclerView
    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileIcon: ImageView = view.findViewById(R.id.profile_icon)
        val studentName: TextView = view.findViewById(R.id.student_name)
        val studentAddress: TextView = view.findViewById(R.id.address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.studentName.text = student.name
        holder.studentAddress.text = student.address

        // Menggunakan Glide untuk memuat gambar dari URL
        Glide.with(holder.itemView.context)
            .load(student.profilePicture) // URL gambar
            .error(R.drawable.ic_error) // Gambar error jika gagal memuat
            .into(holder.profileIcon)
    }

    override fun getItemCount(): Int = studentList.size
}