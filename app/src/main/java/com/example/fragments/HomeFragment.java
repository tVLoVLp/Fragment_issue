package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class HomeFragment extends Fragment {
    Button button_eng,button_ph,button_mth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final RelativeLayout mRelativeLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_home,
                container, false);

        button_eng=(Button) mRelativeLayout.findViewById(R.id.circle_button);
        button_mth=mRelativeLayout.findViewById(R.id.circle_button_math);
        button_ph=mRelativeLayout.findViewById(R.id.circle_button_ph);
        button_ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userscreen=new Intent(getActivity(), Main3ph.class);
                startActivity(userscreen);
            }
        });
        button_mth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userscreen=new Intent(getActivity(), Main3mth.class);
                startActivity(userscreen);
            }
        });
        button_eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userscreen=new Intent(getActivity(), Main2Activity.class);
                startActivity(userscreen);

            }
        });
        return mRelativeLayout;
    }
}
