package com.sana.feature.AccountActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebaseuser.ProfilActivity;
import com.example.firebaseuser.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnLogin, btnReset;
    private TextView link_regist, tvAkun;
    ImageView eye1, eye2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, ProfilActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        link_regist = (TextView) findViewById(R.id.link_regist);
        tvAkun = (TextView) findViewById(R.id.tvAkun);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReset = (Button) findViewById(R.id.btn_reset_password);
        eye2 = findViewById(R.id.eye2);

        eye2.bringToFront();

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        link_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RepasswordActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Masukkan email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Masukkan kata sandi", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                btnReset.setVisibility(View.VISIBLE);
                btnLogin.setVisibility(View.GONE);
                link_regist.setVisibility(View.GONE);
                tvAkun.setVisibility(View.GONE);

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    progressBar.setVisibility(View.GONE);
                                    btnLogin.setVisibility(View.VISIBLE);
                                    link_regist.setVisibility(View.VISIBLE);
                                    btnReset.setVisibility(View.VISIBLE);
                                    tvAkun.setVisibility(View.VISIBLE);
                                    // there was an error
                                    if (password.length() < 6) {
                                        inputPassword.setError(getString(R.string.minimum_password));

                                    } else {
                                        Toast.makeText(LoginActivity.this, "Periksa kembali email dan kata sandi Anda", Toast.LENGTH_LONG).show();

                                    }
                                } else {
                                    /*
                                    if(auth.getCurrentUser().isEmailVerified()){
                                        startActivity(new Intent(LoginActivity.this, ProfilActivity.class));
                                    }else{
                                        Toast.makeText(LoginActivity.this, "Please verify your email address"
                                                , Toast.LENGTH_LONG).show();
                                    }*/
                                    Intent intent = new Intent(LoginActivity.this, ProfilActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(LoginActivity.this, "Berhasil masuk", Toast.LENGTH_LONG).show();
                                    finish();
                                }
                            }
                        });
            }
        });
    }

    public void ShowHidePass(View view) {
        if(view.getId()== R.id.eye2){

            if(inputPassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                ((ImageView)(view)).setImageResource(R.drawable.eye1);

                //Show Password
                inputPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView)(view)).setImageResource(R.drawable.eye2);

                //Hide Password
                inputPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

}