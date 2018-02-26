package com.cgf.learningroom.pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "pet")
public class Pet {
    @PrimaryKey
    public int id;
    public String name;
    public int user_id;
}
