package com.example.fragments.m_Realm;

import android.util.Log;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class WordsRealmHelper {
    Realm realm;
    RealmResults<SpacecraftWords> spacecraftWords;
    Boolean saved=null;

    public WordsRealmHelper(Realm realm) {
        this.realm = realm;
    }

    public Boolean save(final SpacecraftWords spacecraftWords){
        if(spacecraftWords==null){
            saved=false;
        }else {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    try {
                        SpacecraftWords s=realm.copyToRealm(spacecraftWords);
                        saved=true;
                    }catch (RealmException e){
                        e.printStackTrace();
                        saved=false;
                    }
                }
            });
        }
        return saved;
    }
    public void retrieveDB(){
        spacecraftWords=realm.where(SpacecraftWords.class).findAll();
    }

    public ArrayList<SpacecraftWords> refresh(){
        ArrayList<SpacecraftWords> spacecraftNames=new ArrayList<>();
        for (SpacecraftWords s:spacecraftWords)
        {
            spacecraftNames.add(s);

        }
        return spacecraftNames;
    }

}
