package com.ppam.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// Data Access Object
// Added CURD Operations


@Dao
abstract  class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAWish(wishEntity: Wish)

    // Loads all wishes from wish table
    @Query("Select * from `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateAWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteAWish(wish: Wish)

    @Query("Select * from `wish-table` where id=:id" )
    abstract fun getAWishById(id: Long): Flow<Wish>
}