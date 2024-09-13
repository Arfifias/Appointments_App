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

public class Appointments extends AppCompatActivity {

    public EditText editTextTitle, editTextDate, editTextTime, editTextDescription;
    public Button buttonSave;
    public Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonSave = findViewById(R.id.buttonSave);
        buttonBack = findViewById(R.id.buttonBack);

        buttonSave.setOnClickListener(view -> {
            saveAppointment();
            try {
                myAppointments();
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(Appointments.this, MainActivity.class);
            startActivity(intent);
        });

    }

    public void myAppointments() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt"));
        writer.write("Title: " + editTextTitle.getText());
        writer.write("Date: " + editTextDate.getText());
        writer.write("Time: " + editTextTime.getText());
        writer.write("Description: " + editTextDescription.getText());
        writer.close();
    }

    public void saveAppointment() {
        String title = editTextTitle.getText().toString().trim();
        String date = editTextDate.getText().toString().trim();
        String time = editTextTime.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();

        if (title.isEmpty() || date.isEmpty() || time.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "Appointment Saved:\n" +
                    "Title: " + title + "\n" +
                    "Date: " + date + "\n" +
                    "Time: " + time + "\n" +
                    "Description: " + description, Toast.LENGTH_LONG).show();
        }

    }
}