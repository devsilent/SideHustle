package com.silentdev.sidehustle.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.silentdev.sidehustle.R;

public class Main extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Firebase
        mAuth = FirebaseAuth.getInstance();

        Toast.makeText(getApplicationContext(), mAuth.getCurrentUser().getEmail()+"", Toast.LENGTH_SHORT).show();
    }
}