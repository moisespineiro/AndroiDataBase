package com.example.basedatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basedatos.Adapters.StudentsAdapter
import com.example.basedatos.Data.StudentsDb
import com.example.basedatos.Data.StudentsEntity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    val studentsDb = StudentsDb(this)
    private lateinit var studentList: ArrayList<StudentsEntity>
    private lateinit var studentsAdapter: StudentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //solo para la primera vez, después se borra
        studentsDb.studentAdd(StudentsEntity(-1,"Mario 1","Gutierrez",1,"1984/08/02"))
        studentsDb.studentAdd(StudentsEntity(-1,"Mario 2","Gutierrez",1,"1984/08/02"))
        studentsDb.studentAdd(StudentsEntity(-1,"Mario 3","Gutierrez",1,"1984/08/02"))
        studentsDb.studentAdd(StudentsEntity(-1,"Mario 4","Gutierrez",1,"1984/08/02"))
        studentsDb.studentAdd(StudentsEntity(-1,"Mario 5","Gutierrez",1,"1984/08/02"))
        studentsDb.studentAdd(StudentsEntity(-1,"Mario 6","Gutierrez",1,"1984/08/02"))


        studentList = studentsDb.stundetsGetAll2()
        studentsAdapter = StudentsAdapter(studentList,this@MainActivity)

        val linearLayoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        rvwStudents.layoutManager = linearLayoutManager
        rvwStudents.setHasFixedSize(true)
        rvwStudents.adapter = studentsAdapter
    }
}
