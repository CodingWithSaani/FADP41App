package com.tutorials180.fadp41app.RoomLib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.tutorials180.fadp41app.R

class RoomLibWorkingActivity : AppCompatActivity()
{
    private lateinit var mEmployeeDb: EmployeeDb
    private lateinit var addRecordBtn:Button

    private lateinit var fetchRecordsBtn:Button
    private lateinit var dataTV:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_lib_working)

        initializer()
    }

    private fun initializer()
    {
        mEmployeeDb = Room.databaseBuilder(applicationContext,EmployeeDb::class.java,"EmpDB").
        allowMainThreadQueries().build()

        addRecordBtn = findViewById(R.id.addRecordBtn)
        fetchRecordsBtn = findViewById(R.id.retrieveBtn)

        dataTV = findViewById(R.id.dataTV)

        addRecordBtn.setOnClickListener {
            addEmployeeRecord()
        }

        fetchRecordsBtn.setOnClickListener {
            retrieveEmployeeRecords()
        }
    }

    var counter:Int = 0;
    private fun addEmployeeRecord()
    {
        counter++;
        var checker=mEmployeeDb.getEmpDAO().insertEmployeeRecord(Employee(counter,"usman ali","Lecturer"))
        if(checker!=0L)
        {
            Toast.makeText(applicationContext, "Record inserted", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(applicationContext, "Record not inserted", Toast.LENGTH_SHORT).show();
        }

    }

    private fun retrieveEmployeeRecords()
    {
        var employeeDetails= ""
        var listEMp=mEmployeeDb.getEmpDAO().fetchEmployeeRecord()
        for(empSingleRecord in listEMp)
        {
            employeeDetails += "emp id:${empSingleRecord.id}, emp name: ${empSingleRecord.name}" +
                    ", emp des = ${empSingleRecord.des} \n"
        }

        dataTV.text = employeeDetails
    }
}