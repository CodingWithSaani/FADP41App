package com.tutorials180.fadp41app.RoomLib

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "emp_record")
data class Employee(@PrimaryKey @ColumnInfo(name = "emp_id") val id:Int, val name:String, val des:String)
