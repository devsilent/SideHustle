package com.silentdev.sidehustle.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.silentdev.sidehustle.R;

public class Login extends AppCompatActivity {

    EditText eEmail, ePass;
    Button btnLogin, btnRegister;
    TextView txtPrivacy;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        // Layouts
        eEmail = findViewById(R.id.emailEdit);
        ePass = findViewById(R.id.passEdit);
        btnLogin = findViewById(R.id.loginBtn);
        btnRegister = findViewById(R.id.registerBtn);
        txtPrivacy = findViewById(R.id.privacyTxt);

        // Firebase
        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = eEmail.getText().toString();
                String pass = ePass.getText().toString();

                if (email.isEmpty()) {
                    eEmail.setError("Email field is empty");
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    eEmail.setError("Email format is invalid");
                }

                if (pass.isEmpty()) {
                    ePass.setError("Password field is empty");
                }

                emailLogin(email, pass);


            }
        });

    }

    private void emailLogin(String email, String pass) {
        Toast.makeText(getApplicationContext(), email + "\n" + pass, Toast.LENGTH_SHORT).show();
    }
}