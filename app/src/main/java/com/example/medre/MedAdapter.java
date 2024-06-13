package com.example.medre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MedAdapter extends RecyclerView.Adapter<MedAdapter.MyViewHolder> {
    private Context context;
    private ArrayList name_id, medName_id, medQty_id, medTime_id;

    MedAdapter(Context context, ArrayList name_id, ArrayList medName_id, ArrayList medQty_id, ArrayList medTime_id) {
        this.context = context;
        this.name_id = name_id;
        this.medName_id = medName_id;
        this.medQty_id = medQty_id;
        this.medTime_id = medTime_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.medentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id));
        holder.medName_id.setText(String.valueOf(medName_id));
        holder.medQty_id.setText(String.valueOf(medQty_id));
        holder.medTime_id.setText(String.valueOf(medTime_id));

    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id, medName_id, medQty_id, medTime_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.NameTextView);
            medName_id = itemView.findViewById(R.id.medNameTextView);
            medQty_id = itemView.findViewById(R.id.medQTY_TEXTVIEW);
            medTime_id = itemView.findViewById(R.id.medTIME_TEXTVIEW);
        }
    }
}
