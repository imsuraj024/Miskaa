package com.suraj.miskaa.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.suraj.miskaa.databinding.ActivityMainBinding binding = com.suraj.miskaa.databinding.ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}