package com.ppam.wishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(
    private val wishDao: WishDao
) {
    suspend fun addWish(wish: Wish) {
        wishDao.addAWish(wish)
    }

    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getWishById(id: Long) : Flow<Wish> {
        return wishDao.getAWishById(id)
    }

    suspend fun updateAWish(wish: Wish) {
        wishDao.updateAWish(wish)
    }

    suspend fun deleteAWish(wish: Wish) {
        wishDao.deleteAWish(wish)
    }

}