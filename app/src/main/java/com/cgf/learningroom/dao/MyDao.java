package com.cgf.learningroom.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.cgf.learningroom.pojo.User;

@Dao
public interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUsers(User... users);

    /*@Insert
    public void insertBothUsers(User user1, User user2);

    @Insert
    public void insertUsersAndFriends(User user, List<User> friends);

    // Although usually not necessary, you can have this method return an int value instead, indicating the number of rows updated in the database.
    @Update
    public void updateUsers(User... users);*/

    @Query("SELECT * FROM user")
    User[] loadAllUsers();

    /*@Query("SELECT * FROM user WHERE age > :minAge")
    public User[] loadAllUsersOlderThan(int minAge);

    @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
    public User[] loadAllUsersBetweenAges(int minAge, int maxAge);

    @Query("SELECT * FROM user WHERE first_name LIKE :search "
            + "OR last_name LIKE :search")
    public List<User> findUserWithName(String search);

    @Query("SELECT first_name, last_name FROM user")
    public List<NameTuple> loadFullName();

    @Query("SELECT first_name, last_name FROM user WHERE region IN (:regions)")
    public List<NameTuple> loadUsersFromRegions(List<String> regions);

    @Query("SELECT * FROM user WHERE region IN (:regions)")
    public LiveData<List<User>> loadUsersFromRegionsSync(List<String> regions);

    @Query("SELECT * FROM book "
            + "INNER JOIN loan ON loan.book_id = book.id "
            + "INNER JOIN user ON user.id = loan.user_id "
            + "WHERE user.name LIKE :userName")
    public List<Book> findBooksBorrowedByNameSync(String userName);

    @Query("SELECT user.name AS userName, pet.name AS petName "
            + "FROM user, pet "
            + "WHERE user.id = pet.user_id")
    public LiveData<List<UserPet>> loadUserAndPetNames();*/
}