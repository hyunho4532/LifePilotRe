package com.hyun.lifepilotre.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.auth.FirebaseAuth

@Entity(tableName = "user")
class User() {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "userId")
    var id: Int = 0

    @ColumnInfo(name = "authUid")
    var uid: String = FirebaseAuth.getInstance().currentUser!!.uid

    @ColumnInfo(name = "userEmail")
    var email: String? = null

    @ColumnInfo(name = "userPassword")
    var password: String? = null

    constructor(id: Int, uid: String, email: String, password: String) : this() {
        this.id = id
        this.uid = uid
        this.email = email
        this.password = password
    }

    constructor(uid: String, email: String, password: String) : this() {
        this.uid = uid
        this.email = email
        this.password = password
    }
}