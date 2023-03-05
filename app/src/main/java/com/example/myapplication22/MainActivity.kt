package com.example.myapplication22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication22.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.save.setOnClickListener{
             var name = binding.personName.text.toString()
             var number =binding.personid.text.toString()
             var address =binding.personage.text.toString()

             val person = hashMapOf(
                 "name" to name,
                 "id" to number,
                 "age" to address
             )
             db.collection("person")
                 .add(person).addOnSuccessListener { documentReference ->
                     Toast.makeText( applicationContext, "${documentReference.id}",Toast.LENGTH_SHORT).show()
                 }.addOnFailureListener { e ->
                     Toast.makeText( applicationContext, "$e",Toast.LENGTH_SHORT).show()

                 }

         }


    }

    }
