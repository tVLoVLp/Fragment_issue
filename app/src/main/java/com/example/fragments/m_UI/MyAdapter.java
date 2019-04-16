package com.example.fragments.m_UI;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fragments.R;
import com.example.fragments.WordsActivity;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    public Context context;
    public ArrayList<String> spacecrafts;

    public MyAdapter(Context context, ArrayList<String> spacecrafts) {
        this.context = context;
        this.spacecrafts = spacecrafts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.group_item,viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        myViewHolder.nameTxt.setText(spacecrafts.get(position));

        myViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id;
                Log.d(TAG, "onClick: clicked on: " + spacecrafts.get(position));

                Toast.makeText(context, spacecrafts.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, WordsActivity.class);
                intent.putExtra("group_name", spacecrafts.get(position));
                id=spacecrafts.get(position);
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return spacecrafts.size();
    }
}

