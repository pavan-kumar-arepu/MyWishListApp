package com.ppam.wishlistapp.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyWish{
    val wishList = listOf(
        Wish(
            title = "BharatVihar", description = "All about India"
        ),
        Wish(
            title = "Resume Builder", description = "About Your resumes"
        )
        ,Wish(
            title = "Book Laundry", description = "Smart way to book Laundry from home"
        )

    )
}