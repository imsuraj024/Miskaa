package com.suraj.miskaa.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.suraj.miskaa.data.models.RegionModel;

@Dao
public interface RegionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(RegionModel... regionModels);

    @Query("DELETE FROM region_table")
    void deleteAll();
}
