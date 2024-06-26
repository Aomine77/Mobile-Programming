package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudentForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button submitBtn = findViewById(R.id.SubmitBtn);
        EditText idET = findViewById(R.id.Id1);
        EditText name = findViewById(R.id.name);
        RadioButton radioMale = findViewById(R.id.radioBtnMale);
        RadioButton radioFemale = findViewById(R.id.radioBtnFemale);
        Spinner spinner = findViewById(R.id.spinner);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredName = name.getText().toString();
                String selectedGender = "unknown";
                if(radioMale.isChecked()){
                    selectedGender = "Male";
                }else{
                    selectedGender ="Female";
                }
                String enteredId = idET.getText().toString();
                String selectedOption = spinner.getSelectedItem().toString();

                Intent intent = new Intent(StudentForm.this,ViewPage.class);
                intent.putExtra("enteredName", enteredName);
                intent.putExtra("enteredID", enteredId);
                intent.putExtra("selectedGender", selectedGender);
                intent.putExtra("selectedOption", selectedOption);


                startActivity(intent);
            }
        });


    }
}