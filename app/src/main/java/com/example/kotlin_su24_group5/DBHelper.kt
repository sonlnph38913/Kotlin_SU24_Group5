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

@Database(entities = [LoaiModel::class], version = 1)
abstract class LoaiMonDB : RoomDatabase() {
    abstract fun LoaiMonDao(): LoaiMonDao
}
@Dao
interface LoaiMonDao{
    @Query("SELECT * FROM LoaiMon")
    fun getAllLoaiMon(): List<LoaiModel>

    @Query("SELECT * FROM LoaiMon WHERE idLoai IN (:loaiIds)")
    fun loadAllByIds(loaiIds: IntArray): List<LoaiModel>

    @Insert
    fun insert(vararg loaimon: LoaiModel)

    @Delete
    fun delete(loaimon: LoaiModel)

    @Query("DELETE FROM LoaiMon WHERE idLoai = :lid")
    fun deleteLoaiMon(lid: Int)

    @Update
    fun update(loaimon: LoaiModel)
}
