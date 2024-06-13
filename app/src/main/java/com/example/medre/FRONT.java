package com.example.medre;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FRONT extends AppCompatActivity {
    SQLiteDatabase db;
    String dbname = "Medicine";
    private TextView currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_front);
        currentDate = findViewById(R.id.date);
        SimpleDateFormat sdf = new SimpleDateFormat("'Date\n'M/d'\n'");
        String currentDateAndTime = sdf.format(new Date());
        currentDate.setText(currentDateAndTime);

        Button addSched = (Button) findViewById(R.id.addSchedBtn);
        Button sched = (Button) findViewById(R.id.schedBtn);

        addSched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addSched = new Intent(FRONT.this, ADDSCHED.class);
                startActivity(addSched);
            }
        });
        sched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sched =new Intent(FRONT.this, SCHEDULE.class);
                startActivity(sched);
            }
        });


    }


}