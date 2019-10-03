package com.sana.feature.akun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.sana.R;

import java.util.HashMap;
import java.util.Map;

public class SandiActivity extends AppCompatActivity {

    Button btn_send, btn_back;
    EditText email;
    String sEmail;
    String URL_FORGOT = "https://lanuginose-numbers.000webhostapp.com/user/forgot.php";
    StringRequest stringRequest;
    private ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandi);

        btn_send = (Button) findViewById(R.id.btn_send);
        btn_back = (Button) findViewById(R.id.btn_back);
        email = (EditText) findViewById(R.id.email);
        loading = findViewById(R.id.loading);

        submit();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SandiActivity.this, LoginActivity.class));
            }
        });
    }

    private void submit() {
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading.setVisibility(View.VISIBLE);
                btn_send.setVisibility(View.GONE);

                sEmail = email.getText().toString();

                stringRequest = new StringRequest(Request.Method.POST, URL_FORGOT, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("SUCCESS")){
                            Toast.makeText(getApplicationContext(),"Email terkirim", Toast.LENGTH_LONG).show();
                        } else {
                            loading.setVisibility(View.GONE);
                            btn_send.setVisibility(View.VISIBLE);
                            btn_back.setVisibility(View.VISIBLE);
                            Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.GONE);
                        btn_send.setVisibility(View.VISIBLE);
                        btn_back.setVisibility(View.VISIBLE);
                        Toast.makeText(SandiActivity.this, "Cek koneksi", Toast.LENGTH_LONG).show();
                    }
                }){
                    protected Map<String, String> getParams() throws AuthFailureError{
                        Map<String, String> params = new HashMap<>();
                        params.put("email", sEmail);
                        return super.getParams();
                    }
                };
            }
        });
    }
}
