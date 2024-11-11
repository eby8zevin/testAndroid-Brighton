package com.ahmadabuhasan.brightonrealestate.data.local

import android.provider.BaseColumns

internal class DatabaseContract {

    internal class FavoriteColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "favorite"
            const val ID = "id"
            const val POSTER = "poster"
            const val TITLE = "title"
            const val YEAR = "year"
        }
    }
}