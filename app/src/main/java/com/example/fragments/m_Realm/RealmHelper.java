package com.example.fragments.m_Realm;

import android.util.Log;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {
    Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }
    public void save(final Spacecraft spacecraft){
    realm.executeTransaction(new Realm.Transaction() {
        @Override
        public void execute(Realm realm) {
            Spacecraft s=realm.copyToRealm(spacecraft);
        }
    });
    }
    public ArrayList<String> retrieve(){
    ArrayList<String> spacecraftNames=new ArrayList<>();
        RealmResults<Spacecraft>spacecrafts=realm.where(Spacecraft.class).findAll();

        for (Spacecraft s:spacecrafts)
        {
            spacecraftNames.add(s.getName());
        }
        return spacecraftNames;
    }

}
