package com.example.advancedformvalidationapp;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextEmail;
    private EditText editTextPhoneNumber;
    private EditText editTextPassword;
    private EditText editTextRepeatPassword;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextRepeatPassword = findViewById(R.id.editTextRepeatPassword);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String name = editTextName.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phoneNumber = editTextPhoneNumber.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String repeatPassword = editTextRepeatPassword.getText().toString().trim();

                if(name.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imię.", Toast.LENGTH_SHORT).show();
                } else if(surname.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko.", Toast.LENGTH_SHORT).show();
                } else if(email.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić adres e-mail.", Toast.LENGTH_SHORT).show();
                } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(MainActivity.this, "Niepoprawny adres e-mail.", Toast.LENGTH_SHORT).show();
                } else if(phoneNumber.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić numer telefonu.", Toast.LENGTH_SHORT).show();
                } else if(phoneNumber.length()<9){
                    Toast.makeText(MainActivity.this, "Numer telefonu jest zbyt krótki.", Toast.LENGTH_SHORT).show();
                } else if(password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić hasło.", Toast.LENGTH_SHORT).show();
                } else if(password.length()<6){
                    Toast.makeText(MainActivity.this, "Hasło jest zbyt krótkie.", Toast.LENGTH_SHORT).show();
                } else if(repeatPassword.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę ponownie wprowadzić hasło.", Toast.LENGTH_SHORT).show();
                } else if(!repeatPassword.equals(password)){
                    Toast.makeText(MainActivity.this, "Hasła sie nie zgadzają. Spróbuj ponownie", Toast.LENGTH_SHORT).show();
                }  else {
                    Toast.makeText(MainActivity.this, "Formularz przesłany poprawnie.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}