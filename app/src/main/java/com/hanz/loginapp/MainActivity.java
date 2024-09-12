package com.hanz.loginapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etFullName, etUsername, etEmail, txtTgl;
    private Spinner spinnerGender;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        etFullName = findViewById(R.id.editTextText);
        etUsername = findViewById(R.id.editTextText1);
        etEmail = findViewById(R.id.editTextText2);
        spinnerGender = findViewById(R.id.spinner);
        txtTgl = findViewById(R.id.txt_tgl);
        btnRegister = findViewById(R.id.button);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        // You may want to trigger DatePickerDialog when a user clicks on txtTgl
        txtTgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, month1, dayOfMonth) -> {
                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(year1, month1, dayOfMonth);

                    // Format tanggal
                    DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
                    String date = dateFormat.format(selectedDate.getTime());

                    // Set tanggal ke EditText
                    txtTgl.setText(date);
                }, year, month, day);
        datePickerDialog.show();
    }

    private void registerUser() {
        // Retrieve input data
        String fullName = etFullName.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String gender = spinnerGender.getSelectedItem().toString();
        String dateOfBirth = txtTgl.getText().toString();

        // Proceed with registration (e.g., save data or send to server)
        String message = "Halo, nama saya " + fullName + " dengan email saya " + email + " dan tanggal lahir saya " + dateOfBirth;
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
// You can now save the data to your database or send it to a server
    }
}