package com.hyun.lifepilotre.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hyun.lifepilotre.data.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user")
    suspend fun selectUser() : List<User>

    @Query("SELECT * FROM user WHERE authUid = :authUid")
    suspend fun selectFromUser(authUid: String) : List<User>
}