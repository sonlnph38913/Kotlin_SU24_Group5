package com.example.kotlin_su24_group5

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LoaiMon")
data class LoaiModel(
    @PrimaryKey(autoGenerate = true) var idLoai: Int = 0,
    @ColumnInfo(name = "tenLoai") var tenLoai: String?
) {
    fun getThongtinLoaiMon(): String {
        return "Ten Loai: $tenLoai \n"
    }
}