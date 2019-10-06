package com.sana.feature.donasi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sana.MainActivity;
import com.sana.R;
import com.sana.feature.lapor.LaporActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class FormVolunteerActivity extends AppCompatActivity {

    TextInputEditText nama,ktp,tanggal,alamat,hp,email;
    RadioGroup jk;
    Button btn_ikut;

//    private static TextView tgl_pengaduan, tgl_lahir;
    private static final int Date_id = 0, Date_birth = 1;
    private ProgressBar loading;
    private static String URL_VOLUNTEER = "https://lanuginose-numbers.000webhostapp.com/user/volunteer.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_volunteer);

        btn_ikut = findViewById(R.id.btn_ikut_volunteer);
        nama = findViewById(R.id.text_input_nama);
        email = findViewById(R.id.text_input_email);
        alamat = findViewById(R.id.text_input_alamat);
        hp = findViewById(R.id.text_input_nohp);
        ktp = findViewById(R.id.text_input_ktp);
        loading = findViewById(R.id.loading);
        jk = findViewById(R.id.rb_input);
        jk.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup rg, int checkedId) {
                for(int i=0; i<rg.getChildCount(); i++) {
                    RadioButton btn = (RadioButton) rg.getChildAt(i);
                    if(btn.getId() == checkedId) {
                        String text = btn.getText().toString();
                        // do something with text
                        Toast.makeText(FormVolunteerActivity.this,text,Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            }
        });

        getSupportActionBar().setTitle("Isi Formulir");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        tgl_pengaduan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                showDialog(Date_id);
//            }
//        });
//
//        tgl_lahir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                showDialog(Date_birth);
//            }
//        });

//        btn_bukti.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                chooseFile();
//            }
//        });

        btn_ikut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mNama = nama.getText().toString().trim();
                String mEmail = email.getText().toString().trim();
                String mAlamat = alamat.getText().toString().trim();
                String mTelepon = hp.getText().toString().trim();
                String mTglLahir = tanggal.toString().trim();
                String mJenisKelamin =jk.toString().trim();

                if (!mNama.isEmpty() && !mEmail.isEmpty() && !mAlamat.isEmpty() && !mTelepon.isEmpty() && !mTglLahir.isEmpty() && !mJenisKelamin.isEmpty()) {
                    Lapor(mNama, mEmail, mAlamat, mTelepon, mTglLahir , mJenisKelamin);
                } else {
                    nama.setError("Masukkan nama");
                    email.setError("Masukkan email");
                    alamat.setError("Masukkan alamat");
                    hp.setError("Masukkan telepon");
                    tanggal.setError("Masukkan tanggal");
                }
            }
        });
    }

    private void Lapor(final String nama, final String email, final String alamat, final String hp, final String tanggal , final String jk){
        loading.setVisibility(View.VISIBLE);
        btn_ikut.setVisibility(View.GONE);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_VOLUNTEER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")) {
                                Toast.makeText(FormVolunteerActivity.this, "Kamu Berhasil Ikut ", Toast.LENGTH_SHORT).show();
                                Intent intentsucces = new Intent(FormVolunteerActivity.this, MainActivity.class);
                                startActivity(intentsucces);
                            }


                        } catch (JSONException e) {
                            loading.setVisibility(View.GONE);
                            btn_ikut.setVisibility(View.VISIBLE);

                            e.printStackTrace();
                            Toast.makeText(FormVolunteerActivity.this, "Gagal" + e.toString(), Toast.LENGTH_SHORT).show();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.GONE);
                        Toast.makeText(FormVolunteerActivity.this, "Gagal" + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nama",nama);
                params.put("email", email);
                params.put("alamat", alamat);
                params.put("hp", hp);
                params.put("tanggal", tanggal);
                params.put("jk", jk);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

//    protected Dialog onCreateDialog(int id) {
//
//        // Get the calander
//        Calendar c = Calendar.getInstance();
//
//        // From calander get the year, month, day, hour, minute
//        int year = c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH);
//        int day = c.get(Calendar.DAY_OF_MONTH);
//
//        switch (id) {
//            case Date_id:
//
//                // Open the datepicker dialog
//                return new DatePickerDialog(FormVolunteerActivity.this, date_listener, year,
//                        month, day);
//
//            case Date_birth:
//
//                // Open the datepicker dialog
//                return new DatePickerDialog(FormVolunteerActivity.this, date_listener2, year,
//                        month, day);
//        }
//        return null;
//    }

//    // Date picker dialog tgl_pengaduan
//    DatePickerDialog.OnDateSetListener date_listener = new DatePickerDialog.OnDateSetListener() {
//
//        @Override
//        public void onDateSet(DatePicker view, int year, int month, int day) {
//            // store the data in one string and set it to text
//            String date1 = month + "/" + day
//                    + "/" + year;
//            tgl_pengaduan.setText(date1);
//        }
//    };
//
//    // Date picker dialog tgl_lahir
//    DatePickerDialog.OnDateSetListener date_listener2 = new DatePickerDialog.OnDateSetListener() {
//
//        @Override
//        public void onDateSet(DatePicker view, int year, int month, int day) {
//            // store the data in one string and set it to text
//            String date2 = month + "/" + day
//                    + "/" + year;
//            tgl_lahir.setText(date2);
//        }
//    };

//    //File Bukti
//    private void chooseFile(){
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent, "Pilih Gambar"), 1);
//    }


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
