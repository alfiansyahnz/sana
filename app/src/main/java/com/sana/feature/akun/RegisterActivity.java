package com.sana.feature.AccountActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebaseuser.ProfilActivity;
import com.example.firebaseuser.R;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sana.models.User;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputUsername, inputAddress, inputEmail, inputPassword, inputConfirmPassword;
    private Button btnSignUp;
    private TextView link_login;
    private ProgressBar progressBar;
    ImageView eye1, eye2;

    private FirebaseAuth auth;

    DatabaseReference databaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference("User");

        link_login = (TextView) findViewById(R.id.link_login);
        inputUsername = (EditText) findViewById(R.id.username);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        //inputConfirmPassword = (EditText) findViewById(R.id.confirmPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        eye2 = findViewById(R.id.eye2);

        eye2.bringToFront();

        findViewById(R.id.sign_up_button).setOnClickListener(this);


        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                //finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (auth.getCurrentUser() != null) {
            //handle the already login user
        }
    }

    private void registerUser () {
        final String name = inputUsername.getText().toString().trim();
        final String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        //String confirmPassword = inputConfirmPassword.getText().toString().trim();

        if (name.isEmpty()) {
            inputUsername.setError(getString(R.string.input_error));
            inputUsername.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            inputEmail.setError(getString(R.string.input_error));
            inputEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            inputEmail.setError(getString(R.string.input_error_email));
            inputEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            inputPassword.setError(getString(R.string.input_error));
            inputPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            inputPassword.setError(getString(R.string.minimum_password));
            inputPassword.requestFocus();
            return;
        }
/*
        if (!password.equals(confirmPassword)){
            inputConfirmPassword.setError(getString(R.string.unequal_password));
            inputConfirmPassword.requestFocus();
        }
*/

        progressBar.setVisibility(View.VISIBLE);
        btnSignUp.setVisibility(View.GONE);
        link_login.setVisibility(View.GONE);

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            String id = databaseUser.push().getKey();

                            User user = new User(id, name, email);

                            databaseUser.child(id).setValue(user);

                            /*auth.getCurrentUser().sendEmailVerification()
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(RegisterActivity.this, "Registered successfully. Please check your email for verification",
                                                        Toast.LENGTH_LONG).show();
                                                //email.setText("");
                                                //password.setText("");
                                            }else{
                                                Toast.makeText(RegisterActivity.this,  task.getException().getMessage(),
                                                        Toast.LENGTH_LONG).show();
                                            }

                                        }
                                    });*/

                            startActivity(new Intent(RegisterActivity.this, ProfilActivity.class));
                            Toast.makeText(RegisterActivity.this, "Pendaftaran Berhasil", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                            btnSignUp.setVisibility(View.VISIBLE);
                            link_login.setVisibility(View.VISIBLE);
                        }
                    }
                });

    }

    @Override
    public void onClick (View v){
        switch (v.getId()) {
            case R.id.sign_up_button:
                registerUser();
                break;
        }
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}