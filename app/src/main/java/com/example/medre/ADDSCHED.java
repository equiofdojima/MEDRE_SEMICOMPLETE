package com.example.medre;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ADDSCHED extends AppCompatActivity {
    Button timeBtn, addSched;
    EditText name_input, medName_input, medQty_input;
    int Hour, Minute;
    DB db;
    private TextView currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addsched);
        currentDate = findViewById(R.id.date1);
        SimpleDateFormat sdf = new SimpleDateFormat("'Date\n'M/d'\n'");
        String currentDateAndTime = sdf.format(new Date());
        currentDate.setText(currentDateAndTime);
        timeBtn = findViewById(R.id.timebtn);
        addSched = findViewById(R.id.setSched);
        name_input = findViewById(R.id.nameEdt);
        medName_input = findViewById(R.id.mednameEdt);
        medQty_input = findViewById(R.id.qtyEdt);
        db = new DB(this);
        addSched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_input.getText().toString();
                String medName = medName_input.getText().toString();
                String medQty = medQty_input.getText().toString();
                String medTime = timeBtn.getText().toString();

                boolean checkinsertdata =db.addMedInfo(name, medName, medQty, medTime);
                if(checkinsertdata==true){
                    Toast.makeText(ADDSCHED.this, "Added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ADDSCHED.this, "Not Added", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Button back = (Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addSched = new Intent(ADDSCHED.this, FRONT.class);
                startActivity(addSched);
            }
        });


    }
    public void popTimePicker(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                Hour = selectedHour;
                Minute = selectedMinute;
                timeBtn.setText(String.format(Locale.getDefault(), "%02d:%02d", Hour, Minute));


            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, Hour, Minute, false);
        timePickerDialog.setTitle("Select TIme");
        timePickerDialog.show();
    }
}