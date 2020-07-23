package com.andik.solofood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

// Class Splash ini digunakan untuk menampilkan tampilan awal pada saat aplikasi dibuka pertama kali
public class Splash extends AppCompatActivity {

    // deklarasi SharedPreferences untuk menyimpan kondisi dari login user
    SharedPreferences prf;

    // method onCreate, method yang pertama dipanggil ketika activity dipanggil
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // untuk memanggil layout splash agar ditampilkan di layar
        setContentView(R.layout.splash);

        // membuat SharedPreferences dengan nama user dan mode private (hanya aplikasi ini saja yang dapat menggunakan SharedPreferences
        prf = getSharedPreferences("user", MODE_PRIVATE);
        // struktur if untuk mengecek, apakah user sudah pernah login dengan mengecek kondisi username & password
        // jika sudah maka dari class Splash akan menuju ke Main Ac
        if (prf.contains("username") && prf.contains("password")) {
            // Anonymous class dari Handler ini digunakan untuk memberikan jeda sebentar pada activity splash ini
            // dan ketika delay mills sudah terpenuhi maka akan berpindah ke activity lainnya
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // startActivity dibawah ini untuk berganti ke MainActivity
                    startActivity(new Intent(Splash.this, MainActivity.class));
                    // method finish() digunakan untuk mengakhiri activity Splash ini dan beralih ke Activity yang ditunjuk di intent
                    // dan juga fungsi method ini adalah agar activity yang ditunjuk intent jika tombol back ditekan, maka tidak akan kembali
                    // ke activity sebelumnya
                    finish();
                }
            }, 3000); // angka 3000 ini mengartikan bahwa activity ini hanya ditampilkan dalam waktu 3 detik saja (1000 = 1 detik) dan beralih ke activity lainnya
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(Splash.this, LoginActivity.class));
                    finish();
                }
            }, 3000);
        }
    }
}
