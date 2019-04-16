package com.example.fragments.m_UI;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fragments.Main2Activity;
import com.example.fragments.R;
import com.example.fragments.UpdateActivity;

public class MyViewHolder extends RecyclerView.ViewHolder  {

    TextView nameTxt;
    RelativeLayout parentLayout;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTxt=itemView.findViewById(R.id.text_view_title);
        parentLayout = itemView.findViewById(R.id.parent_layout);
    }

}
