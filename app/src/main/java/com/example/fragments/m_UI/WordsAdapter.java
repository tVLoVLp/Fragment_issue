package com.example.fragments.m_UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragments.R;
import com.example.fragments.WordsActivity;
import com.example.fragments.m_Realm.Spacecraft;
import com.example.fragments.m_Realm.SpacecraftWords;

import java.util.ArrayList;

public class WordsAdapter extends RecyclerView.Adapter<WordsViewHolder> {
    Context c;
    ArrayList<SpacecraftWords> spacecraftWords;

    public WordsAdapter(Context c, ArrayList<SpacecraftWords> spacecraftWords) {
        this.c = c;
        this.spacecraftWords = spacecraftWords;
    }


    @NonNull
    @Override
    public WordsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(c).inflate(R.layout.words_item,viewGroup,false);
        return new WordsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WordsViewHolder wordsViewHolder, final int i) {
        SpacecraftWords sw=spacecraftWords.get(i);

        final String name=sw.getWord();
        final String trs=sw.getTranscription();
        final String translate=sw.getTranslate();

        wordsViewHolder.wordTxt.setText(name);
        wordsViewHolder.transcrTxt.setText(trs);
        wordsViewHolder.translateTxt.setText(translate);
    }


    @Override
    public int getItemCount() {
        return spacecraftWords.size();
    }

   
    
}
