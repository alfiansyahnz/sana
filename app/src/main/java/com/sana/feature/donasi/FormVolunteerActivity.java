package com.sana.feature.donasi;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sana.R;

public class FormVolunteerActivity extends AppCompatActivity {

    TextInputEditText nama,ktp,tanggal,alamat,hp,email;
    RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_volunteer);

        nama = findViewById(R.id.text_input_nama);
        ktp = findViewById(R.id.text_input_ktp);
        tanggal = findViewById(R.id.text_input_tanggal);
        alamat = findViewById(R.id.text_input_alamat);
        hp = findViewById(R.id.text_input_nohp);
        email = findViewById(R.id.text_input_email);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Isi Form");

        Button btn_ikut_volun = findViewById(R.id.btn_ikut_volunteer);
        btn_ikut_volun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FormVolunteerActivity.this, "Anda Berhasil Ikut Menjadi Bagian Volunteer" , Toast.LENGTH_SHORT).show();
//                String mNama = nama.getText().toString().trim();
//                String mEmail = email.getText().toString().trim();
//                String mAlamat = alamat.getText().toString().trim();
//                String mTelepon = hp.getText().toString().trim();
//                String mIsi = ktp.getText().toString().trim();
//                String mTglAdu = tanggal.getText().toString().trim();
//
//                if (!mNama.isEmpty() && !mEmail.isEmpty() && !mAlamat.isEmpty() && !mTelepon.isEmpty() && !mIsi.isEmpty() && !mTglAdu.isEmpty() && !mTglLahir.isEmpty()) {
//                    Lapor(mNama, mEmail, mAlamat, mTelepon, mIsi, mTglAdu, mTglLahir);
//                } else {
//                    nm_lapor.setError("Masukkan nama");
//                    email_lapor.setError("Masukkan email");
//                    alamat_lapor.setError("Masukkan alamat");
//                    tlp_lapor.setError("Masukkan telepon");
//                    isi_lapor.setError("Masukkan isi pengaduan");
//                    tgl_pengaduan.setError("Masukkan tanggal");
//                    tgl_lahir.setError("Masukkan tanggal");
//                }
//                Intent intent = new Intent(FormVolunteerActivity.this, DonasiActivity.class);
//                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
