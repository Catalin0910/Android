package com.ai.proiect_cebuc_gabriel_catalin_1079.data;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ai.proiect_cebuc_gabriel_catalin_1079.model.User;

@Database(entities = {User.class}, version = 5, exportSchema = false)
public abstract class UserDatabase  extends RoomDatabase {
    public abstract UserDao getUserDao();
}
