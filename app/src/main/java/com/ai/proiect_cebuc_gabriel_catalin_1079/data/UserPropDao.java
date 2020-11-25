package com.ai.proiect_cebuc_gabriel_catalin_1079.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ai.proiect_cebuc_gabriel_catalin_1079.model.UserProp;

@Dao
public interface UserPropDao {

    @Query("SELECT * FROM UserProp where email= :email and password= :password ")
    UserProp getUserProp(String email, String password);

    @Insert
    void insert(UserProp userProp);

    @Update
    void update(UserProp userProp);

    @Delete
    void delete(UserProp userProp);
}
