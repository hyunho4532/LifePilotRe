package com.hyun.lifepilotre.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class User() {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "userId")
    var id: Int = 0

    @ColumnInfo(name = "authUid")
    var uid: String = ""

    @ColumnInfo(name = "userEmail")
    var email: String = ""

    constructor(id: Int, uid: String, email: String) : this() {
        this.id = id
        this.uid = uid
        this.email = email
    }

    constructor(uid: String, email: String) : this() {
        this.uid = uid
        this.email = email
    }
}