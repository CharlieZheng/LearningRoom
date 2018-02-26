package com.cgf.learningroom.pojo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "user_id",
        onDelete = CASCADE), tableName = "book",
        indices = {@Index("user_id")})
public class Book {
    @PrimaryKey
    public int id;

    public String title;

    @ColumnInfo(name = "user_id")
    public int userId;
}