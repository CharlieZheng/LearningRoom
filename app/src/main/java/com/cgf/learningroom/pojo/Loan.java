package com.cgf.learningroom.pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {@ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "user_id",
        onDelete = CASCADE),
        @ForeignKey(entity = Book.class,
                parentColumns = "id",
                childColumns = "book_id",
                onDelete = CASCADE)}, tableName = "loan",
        primaryKeys = {"user_id", "book_id"}, indices = {@Index(value = {"book_id"}), @Index(value = {"user_id"})})
public class Loan {
    public int user_id;
    public int book_id;
}
