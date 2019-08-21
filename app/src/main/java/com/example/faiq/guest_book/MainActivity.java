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
    EditText etnama,etemail,etalamat,ettanggal,etketerangan;
    ImageView imageView;
    Button bttambah;



    DatePickerDialog datePickerDialog;
    MainURL mainURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainURL = new MainURL();
        imageView = findViewById(R.id.img);
        ettanggal = findViewById(R.id.tanggal);
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
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdatepicker();
            }
        });
    }

    private void senddata() {
        String nama,email,alamat,tanggal,keterangan;
        nama = etnama.getText().toString();
        email = etemail.getText().toString();
        alamat = etalamat.getText().toString();
        tanggal = ettanggal.getText().toString();
        keterangan = etketerangan.getText().toString();
        tambahdata(nama,email,alamat,tanggal,keterangan);
    }

    private void showdatepicker() {
        final Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                String formatTanggal = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(newCalendar.getTime());

                ettanggal.setText(formatTanggal);
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
    void tambahdata(String nama, String email, String alamat, String tanggal, String keterangan){
        mainURL.getAPI().getTamu(nama,alamat,email,tanggal,keterangan).enqueue(new Callback<Tamu>() {
            @Override
            public void onResponse(Call<Tamu> call, Response<Tamu> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"BERHASIL",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Tamu> call, Throwable t) {

            }
        });
    }
}
