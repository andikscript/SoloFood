package com.andik.solofood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// membuat class MainActivity yang berfungsi untuk menampilkan layout activity_main dan juga terdapat
// menu icon dibawah sendiri (bottom navigation)
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    SharedPreferences prf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // untuk mengeload fragment Home, pada awal MainActivity dibuka
        loadFragment(new Home());

        // mengambil data id dari bottom navigation jika bottom navigation di klik
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    // method yang dipanggil untuk mengganti layout pada frame layout activit dengan menggunakan parameter fragment
    private boolean loadFragment(Fragment fragment){
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment) // fragment disini adalah inputan yang diperoleh dari method di bawah ini (onNavigtaion..)
                    .commit();
            return true;
        }
        return false;
    }

    // method dibawah ini adalah method yang dipanggil pada method onCreate yang berfungsi untuk
    // mengganti tampilan fragment pada MainActivity
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) { // masukan disini mengambil data id navigation
            case R.id.nav_home :
                fragment = new Home();
                break;
            case R.id.nav_search :
                fragment = new Search();
                break;
            case R.id.nav_about :
                fragment = new About();
                break;
            case R.id.nav_settings :
                fragment = new Setting();
                break;
        }
        return loadFragment(fragment); // mengembalikan nilai data boolean dengan memberikan nilai integer (R.id... adalah bernilai integer) untuk di load di method load Fragment dan memanggilnya
    }

    // method ini digunakan ketika user menekan tombol back, maka aplikasi menutup (tidak kembali ke activity sebelumnya)
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    // method ini digunakan untuk mengandle onClick searchClick dari button search pada fragment search
    public void searchClick(View view) {
        AppCompatAutoCompleteTextView edt = (AppCompatAutoCompleteTextView) findViewById(R.id.autoComplete);
        String search = edt.getText().toString();

        if (!search.isEmpty()) {
            // intent untuk membuka google maps
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + search))); // untuk menunjukkan tempat maka pakai google.navigation:q=
        } else {
            Toast.makeText(getApplicationContext(), "Enter your find places", Toast.LENGTH_SHORT).show();
        }
    }
}

// jadi modelnya adalah membuat frame layout pada activity utama (karena frame layout sifatnya mengambang diatas activity).
// kemudian dari frame layout itu akan di masukkan diatasnya menggunakan Fragment (fragment itu seperti activity akan tetapi
// berjalan diatas activity) secara bergantian menggunakan id yang di klik dari bottom navigation.
// bottom navigation di klik, kemudian membuat instansiasi objek interface dari BottomNavigation yang gunanya untuk
// mengetahui id yang diklik, kemudian mengembalikan nilai dari id bottom lalu memanggil method untuk mengganti frame layout
// dengan menggunakan fragment. setelah itu membuat method untuk mengganti frame layout dengan menggunakan id tadi.
