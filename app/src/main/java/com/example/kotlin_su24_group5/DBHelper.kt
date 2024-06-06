package com.example.kotlin_su24_group5

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update

@Database(entities = arrayOf(ProductModel::class), version = 1)
abstract class ProductDB : RoomDatabase() {
    abstract fun productDAO(): ProductDao
}

@Dao
interface ProductDao {
    @Query("SELECT * FROM Product")
    fun getAll(): List<ProductModel>

    @Query("SELECT * FROM Product WHERE idPro IN (:proIds)")
    fun loadAllByIds(proIds: IntArray): List<ProductModel>

    @Insert
    fun insert(vararg product: ProductModel)

    @Delete
    fun delete(product: ProductModel)
    @Query("DELETE FROM Product WHERE idPro = :pid")
    fun deleteProduct(pid: Int)
    @Update
    fun update(product: ProductModel)
}