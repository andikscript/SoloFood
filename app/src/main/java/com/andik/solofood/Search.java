package com.andik.solofood;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Search extends Fragment {

    private EditText edt;
    private String[] search = {"Timlo, Solo","Nasi Liwet, Solo","Serabi, Solo","Selat, Solo","Sate Buntel, Solo","Tengkleng, Solo","Brambang Asem, Solo","Lenjongan, Solo","Es Dawet Selasih, Solo","Es Gempol Pleret, Solo"};
    private AutoCompleteTextView autoComplete;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, null);

        autoComplete = rootView.findViewById(R.id.autoComplete);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_item, search);
        autoComplete.setThreshold(1);
        autoComplete.setTextSize(14);
        autoComplete.setAdapter(adapter);
        return rootView;
    }
}
