package com.example.fragments;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fragments.m_Realm.RealmHelper;
import com.example.fragments.m_Realm.Spacecraft;
import com.example.fragments.m_UI.MyAdapter;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class WordsActivity extends AppCompatActivity {
    TextView textView;
    Realm realm;
    ArrayList<String> spacecrafts;
    MyAdapter adapter;
    RecyclerView rv;
    EditText nameEditTxt;
    private static final String TAG="WordsActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        Log.d(TAG, "onCreate: started.");
        FloatingActionButton fab=findViewById(R.id.button_add_group);

        rv=findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        String position=getIntent().getStringExtra("id");
        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(position)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realm=Realm.getInstance(realmConfiguration);

        RealmHelper helper=new RealmHelper(realm);
        spacecrafts=helper.retrieve();

        adapter=new MyAdapter(this,spacecrafts);
        rv.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInputDialog();
            }
        });
    }
    private void displayInputDialog(){
        Dialog d=new Dialog(this);
        d.setTitle("Save to realm");
        d.setContentView(R.layout.input_dialog);

        nameEditTxt=d.findViewById(R.id.nameEditText);
        Button saveBtn=d.findViewById(R.id.create);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spacecraft s=new Spacecraft();
                s.setName(nameEditTxt.getText().toString());

                RealmHelper helper=new RealmHelper(realm);
                helper.save(s);
                nameEditTxt.setText("");

                spacecrafts=helper.retrieve();
                adapter=new MyAdapter(WordsActivity.this,spacecrafts);
                rv.setAdapter(adapter);
            }
        });
        d.show();
        getIncomingIntent();
    }
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
        if(getIntent().hasExtra("group_name")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");
            String title=getIntent().getStringExtra("group_name");
            setTitle(title);
        }
    }
    private void setTitle(String name){
        Log.d(TAG, "setTitle: setting name of group");
        textView=findViewById(R.id.textView);
        textView.setText(name);
    }
}
