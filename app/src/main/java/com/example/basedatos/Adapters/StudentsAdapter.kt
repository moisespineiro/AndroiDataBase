package com.example.basedatos.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.basedatos.Data.StudentsEntity
import com.example.basedatos.R
import kotlinx.android.synthetic.main.item_student.view.*

class StudentsAdapter(val studentsList:ArrayList<StudentsEntity>, val context: Context):
    RecyclerView.Adapter<StudentsHolder>() {
    //Aquí creamos la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StudentsHolder(inflater.inflate(R.layout.item_student,parent,false))
    }

    //Aquí indicamo el numero de elementos que tiene
    override fun getItemCount(): Int {
        return studentsList.size
    }

    //Aquí definimos los valores que va a contener cada elemento de la interfaz item_student
    override fun onBindViewHolder(holder: StudentsHolder, position: Int) {
        holder.txvName.text="${studentsList[position].name} ${studentsList[position].lastName}"
        holder.txvGender.text = if(studentsList[position].gender==1)"Masculino" else "Femenino"
        holder.txvDateBirth.text = studentsList[position].birthday

        holder.ibtEdit.setOnClickListener{
            Toast.makeText(context,"Boton Edit ${studentsList[position].name}", Toast.LENGTH_LONG).show()
        }

        holder.ibtDelete.setOnClickListener{
            Toast.makeText(context,"Boton Delete ${studentsList[position].name}", Toast.LENGTH_LONG).show()
        }
    }
}

class StudentsHolder(view: View): RecyclerView.ViewHolder(view){
    val imvLogoItem: ImageView =view.imvLogoItem
    val txvName=view.txvName
    val txvGender=view.txvGender
    val txvDateBirth=view.txvDateBirth
    val ibtEdit=view.ibtEdit
    val ibtDelete=view.ibtDelete
}