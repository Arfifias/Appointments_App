package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public EditText usernameEditText;
    public EditText passwordEditText;


    public  ArrayList<String> usernames = new ArrayList<>();
    public  ArrayList<String> passwords = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);


        usernames.add("user1");
        passwords.add("password1");
        usernames.add("user2");
        passwords.add("password2");
        usernames.add("user3");
        passwords.add("password3");
        usernames.add("user4");
        passwords.add("password4");

        try {
            myBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Appointments myAppointment = new Appointments();

        try {
            myAppointment.myAppointments();
        } catch (IOException e) {
            e.printStackTrace();
        }


        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Appointments.class);
            startActivity(intent);

            try{
                handleLogin();
            }catch (IOException e){
                e.printStackTrace();
            }

        });

            registerButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            });


    }


    public void myBuffer() throws IOException {

         Register register2 =  new Register();

        BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt"));
        writer.write("User: " + register2.usernameEditText.getText());
        writer.write("Password: " + register2.passwordEditText.getText());
        writer.write("Email: " + register2.emailEditText.getText());
        writer.close();
    }


    public void handleLogin() throws IOException {

        String enteredUsername = usernameEditText.getText().toString();
        String enteredPassword = passwordEditText.getText().toString();


        if (usernames.contains(enteredUsername)) {
            int index = usernames.indexOf(enteredUsername);
            if (passwords.get(index).equals(enteredPassword)) {
                Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Incorrect password!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Username not found!", Toast.LENGTH_SHORT).show();
        }


        boolean flag = true;

        while (flag) {

            Register register = new Register();

            String myUser = register.usernameEditText.getText().toString();
            String myPassword = register.passwordEditText.getText().toString();

            if(usernames.contains(myUser)){
                int index_user = usernames.indexOf(myUser);
                if (passwords.get(index_user).equals(myPassword)){
                    Toast.makeText(MainActivity.this,"Valid User",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Invalid User",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(MainActivity.this,"User found",Toast.LENGTH_SHORT).show();
            }

            flag = false;


            if (usernames.isEmpty()){
                if(passwords.isEmpty()){
                    System.exit(1000000000);
               }
            }
        }
    }
}

