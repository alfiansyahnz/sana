package com.sana.feature.lapor;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sana.R;
import com.sana.feature.akun.ProfilActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class LaporActivity extends AppCompatActivity {
    private static TextView tgl_pengaduan, tgl_lahir;
    private static final int Date_id = 0, Date_birth = 1;
    private Button btn_lapor, btn_bukti;
    private EditText nm_lapor, email_lapor, alamat_lapor, tlp_lapor, isi_lapor;
    private ProgressBar loading;
    private static String URL_LAPOR = "https://serversana.000webhostapp.com/lapor.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lapor);
        tgl_pengaduan = (TextView) findViewById(R.id.tgl_pengaduan);
        tgl_lahir = (TextView) findViewById(R.id.tgl_lahir);
        btn_lapor = (Button) findViewById(R.id.btn_lapor);
        btn_bukti = (Button) findViewById(R.id.btn_bukti);
        nm_lapor = (EditText) findViewById(R.id.nm_lapor);
        email_lapor = (EditText) findViewById(R.id.email_lapor);
        alamat_lapor = (EditText) findViewById(R.id.alamat_lapor);
        tlp_lapor = (EditText) findViewById(R.id.tlp_lapor);
        isi_lapor = (EditText) findViewById(R.id.isi_lapor);
        loading = findViewById(R.id.loading);

        tgl_pengaduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                showDialog(Date_id);
            }
        });

        tgl_lahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                showDialog(Date_birth);
            }
        });

        btn_bukti.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                chooseFile();
            }
        });

        btn_lapor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Lapor();
                //Intent i = new Intent(LaporActivity.this, ProfilActivity.class);
                //startActivity(i);
            }
        });
    }

    private void Lapor(){
        loading.setVisibility(View.VISIBLE);
        btn_lapor.setVisibility(View.GONE);

        final String nm_lapor = this.nm_lapor.getText().toString().trim();
        final String email_lapor = this.email_lapor.getText().toString().trim();
        final String alamat_lapor = this.alamat_lapor.getText().toString().trim();
        final String tlp_lapor = this.tlp_lapor.getText().toString().trim();
        final String isi_lapor = this.isi_lapor.getText().toString().trim();
        final String tgl_pengaduan = this.tgl_pengaduan.getText().toString().trim();
        final String tgl_lahir = this.tgl_lahir.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LAPOR,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")) {
                                Toast.makeText(LaporActivity.this, "Laporan Pengaduan Berhasil Dikirim", Toast.LENGTH_SHORT).show();
                                Intent intentsucces = new Intent(LaporActivity.this, ProfilActivity.class);
                                startActivity(intentsucces);
                            }


                        } catch (JSONException e) {
                            loading.setVisibility(View.GONE);
                            btn_lapor.setVisibility(View.VISIBLE);

                            e.printStackTrace();
                            Toast.makeText(LaporActivity.this, "Gagal" + e.toString(), Toast.LENGTH_SHORT).show();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.GONE);
                        Toast.makeText(LaporActivity.this, "Gagal" + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nm_lapor", nm_lapor);
                params.put("email_lapor", email_lapor);
                params.put("alamat_lapor", alamat_lapor);
                params.put("tlp_lapor", tlp_lapor);
                params.put("isi_lapor", isi_lapor);
                params.put("tgl_pengaduan", tgl_pengaduan);
                params.put("tgl_lahir", tgl_lahir);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    protected Dialog onCreateDialog(int id) {

        // Get the calander
        Calendar c = Calendar.getInstance();

        // From calander get the year, month, day, hour, minute
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        switch (id) {
            case Date_id:

                // Open the datepicker dialog
                return new DatePickerDialog(LaporActivity.this, date_listener, year,
                        month, day);

            case Date_birth:

                // Open the datepicker dialog
                return new DatePickerDialog(LaporActivity.this, date_listener2, year,
                        month, day);
        }
        return null;
    }

    // Date picker dialog tgl_pengaduan
    DatePickerDialog.OnDateSetListener date_listener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            // store the data in one string and set it to text
            String date1 = String.valueOf(month) + "/" + String.valueOf(day)
                    + "/" + String.valueOf(year);
            tgl_pengaduan.setText(date1);
        }
    };

    // Date picker dialog tgl_lahir
    DatePickerDialog.OnDateSetListener date_listener2 = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            // store the data in one string and set it to text
            String date2 = String.valueOf(month) + "/" + String.valueOf(day)
                    + "/" + String.valueOf(year);
            tgl_lahir.setText(date2);
        }
    };

    //File Bukti
    private void chooseFile(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Pilih Gambar"), 1);
    }
}