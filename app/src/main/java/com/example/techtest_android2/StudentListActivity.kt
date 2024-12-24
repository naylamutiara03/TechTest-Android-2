package com.example.techtest_android2

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StudentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list) // Pastikan ini adalah layout yang benar

        // Mengambil referensi ke RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Referensi ke ProgressBar dan BackIcon
        val progressBar: ProgressBar = findViewById(R.id.progress_bar)
        val backIcon: ImageView = findViewById(R.id.back_icon)

        // Sample student data
        val studentList = listOf(
            Student("John Doe", "https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg", "Jalan A"),
            Student("Jane Smith", "https://images.pexels.com/photos/1674752/pexels-photo-1674752.jpeg", "Jalan B"),
            Student("Alice Johnson", "https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg", "Jalan C"),
            Student("Bob Brown", "https://images.pexels.com/photos/697509/pexels-photo-697509.jpeg", "Jalan D"),
            Student("Charlie Black", "https://images.pexels.com/photos/1370750/pexels-photo-1370750.jpeg", "Jalan E"),
            Student("Diana Prince", "https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg", "Jalan F"),
            Student("Ethan Hunt", "https://images.pexels.com/photos/3785079/pexels-photo-3785079.jpeg", "Jalan G"),
            Student("Fiona Glenanne", "https://images.pexels.com/photos/1435612/pexels-photo-1435612.jpeg", "Jalan H"),
            Student("George Clooney", "https://images.pexels.com/photos/810775/pexels-photo-810775.jpeg", "Jalan I"),
            Student("Hannah Montana", "https://images.pexels.com/photos/762020/pexels-photo-762020.jpeg", "Jalan J")
        )

        val adapter = StudentAdapter(studentList)
        recyclerView.adapter = adapter

        // Menambahkan listener untuk ikon back
        backIcon.setOnClickListener {
            // Tampilkan ProgressBar
            progressBar.visibility = View.VISIBLE
            backIcon.isEnabled = false // Nonaktifkan sementara tombol back

            // Simulasikan proses loading sebelum kembali
            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = View.GONE
                backIcon.isEnabled = true
                finish() // Menutup StudentListActivity
            }, 2000) // Durasi simulasi loading (2 detik)
        }
    }
}