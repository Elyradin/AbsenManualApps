package com.example.absenmanualapps;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class DaftarFragment extends Fragment {


    public DaftarFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daftar, container, false);
        Button daftar = view.findViewById(R.id.btn_daftar);
        daftar.setOnClickListener(view1 -> {
            Intent intent = new Intent(view.getContext(), SecondActivity.class);
            startActivity(intent);
        });
        return view;
    }
}