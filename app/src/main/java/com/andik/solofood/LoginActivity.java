package com.andik.solofood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

// class ini digunakan untuk tampilan login ketika user akan masuk ke aplikasi, untuk mengakses fitur-fitur dari aplikasi
public class LoginActivity extends AppCompatActivity {

    SharedPreferences prf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // deklarasi CheckBox dibawah ini untuk menghandle id dari check_box
        CheckBox checkBox = (CheckBox) findViewById(R.id.check_box);
        // anonymous class dibawah ini untuk menghandle event dari checkbox ketika di centang
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Toast digunakan untuk menampilkan notifikasi ke aplikasi user
                Toast.makeText(getApplicationContext(), "Remember", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // di dalam file layout Login terdapat event onClick pada TextView, method dibawah ini untuk menghandlenya
    public void clickHere(View v) {
        Toast.makeText(getApplicationContext(), "Just Moment", Toast.LENGTH_SHORT).show();
    }

    public void loginClick(View view) {
        // deklarasi untuk menerima inputan dari user melalui id username dan password
        EditText edt = (EditText) findViewById(R.id.username);
        EditText edtSatu = (EditText) findViewById(R.id.password);

        // deklarasi variable username dan password, yang didalamnya terdapat value dari inputan user
        String username = edt.getText().toString();
        String password = edtSatu.getText().toString();

        // mengecek kondisi dari inputan user, jika inputan user benar maka akan masuk ke activity MainActivity
        // jika salah maka akan menampilkan notifikasi Username or Password is Wrong
        // dan jika salah satu kosong, maka akan menampilkan notifikasi Username or Password not Empty
        if (!username.isEmpty() && !password.isEmpty()) {
            if (username.equals("sinus") && password.equals("sinus")) {
                Intent in = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(in);
                finish();
                // prf dibawah ini akan mengedit dari SharedPreferences user, yang dimana akan memasukkan string
                // username dan password, yang digunakan untuk mengecek kondisi ketika aplikasi di buka awal pertama
                prf = getSharedPreferences("user", MODE_PRIVATE);
                SharedPreferences.Editor editor = prf.edit();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.commit();
            } else {
                Toast.makeText(getApplicationContext(), "Username or Password is Wrong", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(getApplicationContext(), "Username or Password not Empty", Toast.LENGTH_SHORT).show();
        }
    }
}