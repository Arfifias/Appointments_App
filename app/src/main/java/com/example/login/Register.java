package com.example.login;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {


    public EditText usernameEditText, emailEditText, passwordEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button registerButton = findViewById(R.id.registerButton);
        Button backButton = findViewById(R.id.myBackButton);

        registerButton.setOnClickListener(v -> {

            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);

            registerUser();

        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);
        });

    }



    public void registerUser() {

        String username = usernameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();


        String message = "Username: " + username + "\nEmail: " + email + "\nPassword: " + password;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();



    }

}