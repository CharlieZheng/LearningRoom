package com.cgf.learningroom.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.cgf.learningroom.dao.MyDao;
import com.cgf.learningroom.pojo.Book;
import com.cgf.learningroom.pojo.Loan;
import com.cgf.learningroom.pojo.Pet;
import com.cgf.learningroom.pojo.User;

@Database(entities = {User.class, Book.class, Pet.class, Loan.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MyDao userDao();
}