package com.andik.solofood;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Setting extends Fragment {

    private String[] title = {"Account", "Help", "Logout"};
    private int[] image = {R.drawable.ic_baseline_insert_emoticon_24, R.drawable.ic_baseline_help_outline_24, R.drawable.ic_baseline_exit_to_app_24};

    SharedPreferences prf;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting, null);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        ListView listView = (ListView) rootView.findViewById(R.id.list_setting);

        for (int i = 0; i < title.length; i++) {
            HashMap<String, String> has = new HashMap<String, String>();
            has.put("title", title[i]);
            has.put("image", Integer.toString(image[i]));
            aList.add(has);

            String[] from = {"title", "image"};
            int[] to = {R.id.setting_title, R.id.setting_image};

            SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), aList, R.layout.list_setting, from, to);
            listView.setAdapter(simpleAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0:
                            account();
                            break;
                        case 1:
                            help();
                            break;
                        case 2:
                            logout();
                    }
                }
            });
        }

        return rootView;
    }

    public void account(){
        Toast.makeText(getContext(), "Yes, this is your account", Toast.LENGTH_SHORT).show();
    }

    public void help(){
        Toast.makeText(getContext(), "You can ask admin", Toast.LENGTH_SHORT).show();
    }

    // untuk menghandle event onClick logout pada fragment_setting di bagian list logout
    public void logout(){
        // AlertDialog ini berfungsi untuk menampilkan dari notifikasi jika user mengklik list dari logout
        // dan akan muncul box dengan pilihan yes atau no
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setMessage("Are You Want Logout ?");
        alert.setCancelable(true);

        alert.setPositiveButton(
                "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // jika user memilih yes, maka fragment ini berakhir dan beralih ke activity LoginActivity
                        getActivity().finish();
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        // digunakan untuk memanggil method logoutShared()
                        logoutShared();
                    }
                }
        );

        alert.setNegativeButton(
                "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );

        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    // method dibawah ini digunakan untuk menghapus kondisi dari user untuk menghapus semua string yang disimpan
    public void logoutShared() {
        prf = this.getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prf.edit();
        editor.clear();
        editor.commit();
    }
}
