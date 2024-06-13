package com.example.medre;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SCHEDULE extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name, medname, medqty, medtime;
    DB db;
    MedAdapter adapter;
    private TextView currentDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_schedule);
        currentDate = findViewById(R.id.date1);
        SimpleDateFormat sdf = new SimpleDateFormat("'Date\n'M/d'\n'");
        String currentDateAndTime = sdf.format(new Date());
        currentDate.setText(currentDateAndTime);
        db = new DB(this);
        name = new ArrayList<>();
        medname = new ArrayList<>();
        medqty = new ArrayList<>();
        medtime = new ArrayList<>();
        recyclerView = findViewById(R.id.rV);
        adapter = new MedAdapter(this, name, medname, medqty, medtime);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata() {
        Cursor cursor = db.getData();
                if(cursor.getCount()==0){
                    Toast.makeText(this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                } else{
                    while(cursor.moveToNext()){
                        name.add(cursor.getString(0));
                        medname.add(cursor.getString(1));
                        medqty.add(cursor.getString(2));
                        medtime.add(cursor.getString(3));
                    }
                }
    }
}