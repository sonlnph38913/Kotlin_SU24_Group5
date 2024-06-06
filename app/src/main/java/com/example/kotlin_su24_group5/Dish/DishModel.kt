package com.example.kotlin_su24_group5.Dish

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dish")
data  class DishModel(
    @PrimaryKey(autoGenerate = true) var idDish: Int = 0,
    @ColumnInfo(name = "TenMon") var TenMon: String?,
    @ColumnInfo(name = "HinhAnh") var HinhAnh: String?,
    @ColumnInfo(name = "GiaBan") var GiaBan: Float?,

) {
    fun getShowDish(): String {
        return "Ten Mon: $TenMon \n" +
                "Hinh Anh: $HinhAnh \n" +
                "Gia Ban: $GiaBan \n"
    }

}