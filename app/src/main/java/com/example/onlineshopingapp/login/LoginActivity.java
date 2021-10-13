package com.example.onlineshopingapp.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.onlineshopingapp.R;
import com.example.onlineshopingapp.activity.MainActivity;
import com.example.onlineshopingapp.databinding.ActivityLoginBinding;
import com.example.onlineshopingapp.productdetail.ProductDetail;
import com.example.onlineshopingapp.register.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private  FirebaseAuth mAuth;

    private ProgressDialog loader;
    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActivityLoginBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loader = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = mAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

//onclicklogin
        bind.loginpagequestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        bind.cirLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = bind.editTextEmail.getText().toString().trim();
                String password = bind.editTextPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    bind.editTextEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    bind.editTextPassword.setError("Password is required");
                    return;
                } else {
                    loader.setMessage("Login in progress");
                    loader.setCancelable(false);
                    // Loader.setCanceledOnTouchOutside(false);
                    loader.show();

                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                String error = task.getException().toString();
                                Toast.makeText(LoginActivity.this, "Login failed" + error, Toast.LENGTH_SHORT).show();

                            }
                            loader.dismiss();
                        }

                    });


                }


            }
        });
    }
    }

