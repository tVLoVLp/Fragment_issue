package com.example.fragments.m_UI;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fragments.R;

public class WordsViewHolder extends RecyclerView.ViewHolder {
    TextView wordTxt;
    TextView transcrTxt;
    TextView translateTxt;
    RelativeLayout parentLayout;
    public WordsViewHolder(@NonNull View itemView) {
        super(itemView);
        wordTxt=itemView.findViewById(R.id.text_view_word);
        transcrTxt=itemView.findViewById(R.id.text_view_transcription);
        translateTxt=itemView.findViewById(R.id.text_view_translate);
        parentLayout=itemView.findViewById(R.id.parent_layout_words);

    }
}
