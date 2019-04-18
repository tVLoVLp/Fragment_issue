package com.example.fragments.m_Realm;

import io.realm.RealmObject;

public class SpacecraftWords extends RealmObject {
    private int wordId;
    private String word;
    private String transcription;
    private String translate;


    public void setWord(String word) { this.word = word; }

    public void setTranscription(String transcription) { this.transcription = transcription; }

    public void setTranslate(String translate) { this.translate = translate; }

    public void setWordId(int wordId) { this.wordId = wordId; }

    public int getWordId() { return wordId; }

    public String getWord() { return word; }

    public String getTranscription() { return transcription; }

    public String getTranslate() { return translate; }
}
