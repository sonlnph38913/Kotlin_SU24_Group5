package com.example.kotlin_su24_group5.Dish

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update

@Database(entities = arrayOf(DishModel::class), version = 1)
abstract class DishDB : RoomDatabase() {
    abstract fun DishDao(): DishDao
}

@Dao
interface DishDao {
    @Query("SELECT * FROM Dish")
    fun getAll(): List<DishModel>

    @Query("SELECT * FROM Dish WHERE idDish IN (:proIds)")
    fun loadAllByIds(proIds: IntArray): List<DishModel>

    @Insert
    fun insert(vararg dish: DishModel)

    @Delete
    fun delete(product: DishModel)
    @Query("DELETE FROM Dish WHERE idDish = :pid")
    fun deleteDish(pid: Int)
    @Update
    fun update(product: DishModel)
}