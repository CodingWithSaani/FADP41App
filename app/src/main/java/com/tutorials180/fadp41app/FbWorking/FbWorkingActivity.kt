package com.tutorials180.fadp41app.FbWorking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tutorials180.fadp41app.R

class FbWorkingActivity : AppCompatActivity()
{
    private val mFirestore = Firebase.firestore
    private lateinit var addDataBtn:Button

    private lateinit var progressBar:ProgressBar
    private lateinit var addDocumentWithKey:Button

    private lateinit var dataTV:TextView
    private lateinit var getSingleDocumentBtn:Button

    private lateinit var getCollectionBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fb_working)

        addDataBtn = findViewById(R.id.fb_addDataBtn)
        progressBar = findViewById(R.id.progressBar)

        addDocumentWithKey = findViewById(R.id.addDocumentWithKeyBtn)
        getSingleDocumentBtn = findViewById(R.id.fb_getDataBtn)

        dataTV = findViewById(R.id.dataTV)
        getCollectionBtn = findViewById(R.id.fb_getCollectionBtn)

        addDataBtn.setOnClickListener {
            addDataToFB()
        }

        addDocumentWithKey.setOnClickListener {
            addSingleDocumentWithKey()
        }
        getSingleDocumentBtn.setOnClickListener {
            getDocumentFromFirestore()
        }

        getCollectionBtn.setOnClickListener {
            getCompleteCollection()
        }
    }

    private fun getCompleteCollection() {
        try
        {
            progressBar.visibility = View.VISIBLE
            mFirestore.collection("FADP42Students")
                .get()
                .addOnSuccessListener {
                    progressBar.visibility = View.INVISIBLE
                    var allData = ""
                    for (singleDoc in it)
                    {
                        allData +="name = ${singleDoc.getString("name")} \n"
                    }
                    dataTV.text = allData
                }
                .addOnFailureListener {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(applicationContext, "${it.message.toString()}", Toast.LENGTH_SHORT).show();
                }
        }
        catch(ex:Exception)
        {
            progressBar.visibility = View.INVISIBLE
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun addDataToFB()
    {
        try
        {
            progressBar.visibility = View.VISIBLE

            var singleDocument = HashMap<String,Any>()
            singleDocument.set("name","Ali Raza")

            singleDocument.set("age",29)
            mFirestore.collection("FADP42Students")
                .add(singleDocument)
                .addOnSuccessListener {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(applicationContext, "Document Added", Toast.LENGTH_SHORT).show();
                }
                .addOnFailureListener {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(applicationContext, "${it.message.toString()}", Toast.LENGTH_SHORT).show();
                }

        }
        catch (ex:Exception)
        {
            progressBar.visibility = View.INVISIBLE
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun addSingleDocumentWithKey()
    {
        try
        {
            progressBar.visibility = View.VISIBLE
            val documentToBeAdded = hashMapOf(
                "name" to "Hamza Ali",
                "age" to 29,
                "address" to "Lahore"
            )

            mFirestore.collection("FADP42Students")
                .document("hamza_document")
                .set(documentToBeAdded)
                .addOnSuccessListener {  _:Void? ->
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(applicationContext, "Document with key added", Toast.LENGTH_SHORT).show();
                }
                .addOnFailureListener {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(applicationContext, "${it.message.toString()}", Toast.LENGTH_SHORT).show();
                }
        }
        catch(ex:Exception)
        {
            progressBar.visibility = View.INVISIBLE
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun getDocumentFromFirestore()
    {
        try
        {
            progressBar.visibility = View.VISIBLE
            mFirestore.collection("FADP42Students")
                .document("ali_raza_record")
                .get()
                .addOnSuccessListener {
                    progressBar.visibility = View.INVISIBLE
                    dataTV.text = "name = ${it.getString("name")} \nage=${it.getLong("age")}"
                }
                .addOnFailureListener {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(applicationContext, "${it.message.toString()}", Toast.LENGTH_SHORT).show();
                }
        }
        catch(ex:Exception)
        {
            progressBar.visibility = View.INVISIBLE
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }










}