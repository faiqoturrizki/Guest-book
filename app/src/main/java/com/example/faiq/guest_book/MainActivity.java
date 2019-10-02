package com.example.faiq.guest_book;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.faiq.guest_book.model.Tamu;
import com.example.faiq.guest_book.network.MainURL;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText etnama, etemail, etalamat, etketerangan;
    Button bttambah;


    DatePickerDialog datePickerDialog;
    MainURL mainURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainURL = new MainURL();
        etnama = findViewById(R.id.nama);
        etemail = findViewById(R.id.email);
        etalamat = findViewById(R.id.alamat);
        etketerangan = findViewById(R.id.ket);
        bttambah = findViewById(R.id.tambah);
        bttambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senddata();
            }
        });

    }

    private void senddata() {
        Toast.makeText(MainActivity.this,"Klik",Toast.LENGTH_SHORT).show();

        String nama, email, alamat, tanggal, keterangan;
        nama = etnama.getText().toString();
        email = etemail.getText().toString();
        alamat = etalamat.getText().toString();
        keterangan = etketerangan.getText().toString();
        tambahdata(nama, email, alamat, keterangan);
    }

    void tambahdata(String nama, String email, String alamat, String keterangan) {
        mainURL.getAPI().getTamu(nama, alamat, email, keterangan).enqueue(new Callback<Tamu>() {
            @Override
            public void onResponse(Call<Tamu> call, Response<Tamu> response) {
                if (response.isSuccessful()) {
                    Intent intent = new Intent(MainActivity.this,FinishActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this,"Gagal",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Tamu> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}

