package com.example.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edit_title;
    Button button_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edit_title=findViewById(R.id.edit_title);
        button_update=findViewById(R.id.button_update);
        button_update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
