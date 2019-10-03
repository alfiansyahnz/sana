package com.sana.feature.akun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText nama, email, password;
    private Button btn_regist;
    private ProgressBar loading;
    private TextView link_login, teks;
    ImageView eye1, eye2;
    private static String URL_REGIST = "https://lanuginose-numbers.000webhostapp.com/user/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loading = findViewById(R.id.loading);
        nama = findViewById(R.id.nama);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_regist = findViewById(R.id.btn_regist);
        link_login = findViewById(R.id.link_login);
        teks = findViewById(R.id.teks);
        eye2 = findViewById(R.id.eye2);

        eye2.bringToFront();

        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_regist.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String mNama = nama.getText().toString().trim();
                        String mEmail = email.getText().toString().trim();
                        String mPass = password.getText().toString().trim();


                        if (!mNama.isEmpty() && !mEmail.isEmpty() && !mPass.isEmpty()) {
                            Regist(mNama, mEmail, mPass);
                        } else {
                            nama.setError("Masukkan nama");
                            email.setError("Masukkan email");
                            password.setError("Masukkan kata sandi");
                        }
                    }
                });
            }
        });

        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    private void Regist(final String nama, final String email, final String password) {
        loading.setVisibility(View.VISIBLE);
        btn_regist.setVisibility(View.GONE);
        link_login.setVisibility(View.GONE);
        teks.setVisibility(View.GONE);

        /*final String nama = this.nama.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String password = this.password.getText().toString().trim();*/

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")) {
                                Toast.makeText(RegisterActivity.this, "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();
                                Intent intentsuccecs = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intentsuccecs);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(RegisterActivity.this, "Pendaftaran Gagal" + e.toString(), Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                            btn_regist.setVisibility(View.VISIBLE);
                            link_login.setVisibility(View.VISIBLE);
                            teks.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterActivity.this, "Pendaftaran Gagal" + error.toString(), Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btn_regist.setVisibility(View.VISIBLE);
                        link_login.setVisibility(View.VISIBLE);
                        teks.setVisibility(View.VISIBLE);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nama", nama);
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

    public void ShowHidePass(View view) {
        if(view.getId()== R.id.eye2){

            if(password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                ((ImageView)(view)).setImageResource(R.drawable.eye1);

                //Show Password
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView)(view)).setImageResource(R.drawable.eye2);

                //Hide Password
                password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
}
