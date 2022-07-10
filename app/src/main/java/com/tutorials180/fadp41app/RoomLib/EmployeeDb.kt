package com.tutorials180.fadp41app.RoomLib

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDb:RoomDatabase()
{
    abstract fun getEmpDAO():EmpDAO
}