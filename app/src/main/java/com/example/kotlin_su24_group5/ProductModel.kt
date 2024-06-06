package com.example.kotlin_su24_group5

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data  class ProductModel(
    @PrimaryKey(autoGenerate = true) var idPro: Int = 0,
    @ColumnInfo(name = "namePro") var namePro: String?,
    @ColumnInfo(name = "imgPro") var imgPro: String?,
    @ColumnInfo(name = "pricePro") var pricePro: Float?,

) {
    fun getThongtinPro(): String {
        return "Ten Mon: $namePro \n" +
                "Hinh Anh: $imgPro \n" +
                "Gia Ban: $pricePro \n"

    }

}