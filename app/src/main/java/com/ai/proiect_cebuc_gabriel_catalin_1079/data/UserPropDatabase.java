package com.ai.proiect_cebuc_gabriel_catalin_1079.data;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ai.proiect_cebuc_gabriel_catalin_1079.model.UserProp;

@Database(entities = {UserProp.class}, version = 1, exportSchema = false)
public abstract class UserPropDatabase extends RoomDatabase {
    public abstract UserPropDao getUserPropDao();
}
