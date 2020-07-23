package com.andik.solofood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;

public class About extends Fragment {

    String[] nama = {"Andik Saputro", "Andik Saputro", "Andik Saputro"};
    String[] deskripsi = {"Java Developer & Android Developer", "Java Developer & Android Developer", "Java Developer & Android Developer"};
    int[] image = {R.drawable.andik,R.drawable.andik,R.drawable.andik};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_about,null);
        ListView listView = (ListView) rootView.findViewById(R.id.list_about);

        ArrayList<HashMap<String,String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < nama.length; i++) {
            HashMap<String,String> has = new HashMap<>();
            has.put("image", Integer.toString(image[i]));
            has.put("nama", nama[i]);
            has.put("deskripsi", deskripsi[i]);
            aList.add(has);

            String[] from = {"image", "nama", "deskripsi"};
            int[] to = {R.id.about_image, R.id.about_nama, R.id.about_deskripsi};

            SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), aList, R.layout.list_about, from, to);
            listView.setAdapter(simpleAdapter);
        }

        return rootView;
    }
}
