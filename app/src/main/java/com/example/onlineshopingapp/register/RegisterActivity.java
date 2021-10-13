package com.example.onlineshopingapp.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.onlineshopingapp.R;
import com.example.onlineshopingapp.databinding.ActivityRegisterBinding;
import com.example.onlineshopingapp.login.LoginActivity;
import com.example.onlineshopingapp.productdetail.ProductDetail;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    private ProgressDialog loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_register);

        ActivityRegisterBinding bindReg = DataBindingUtil.setContentView(this, R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        loader = new ProgressDialog(this);


        bindReg.RegloginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        bindReg.cirRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = bindReg.editTextEmail.getText().toString().trim();
                String password = bindReg.editTextPassword.getText().toString().trim();
                String Name = bindReg.editTextName.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    bindReg.editTextEmail.setError("email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    bindReg.editTextPassword.setError("Password required");
                    return;
                }
                if (TextUtils.isEmpty(Name)) {
                    bindReg.editTextName.setError("Name required");
                    return;

                } else {
                    loader.setMessage("Registration in progress");
                    loader.setCanceledOnTouchOutside(false);
                    loader.show();
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                                loader.dismiss();
                            } else {
                                String error = task.getException().toString();
                                Toast.makeText(RegisterActivity.this, "Registration failed" + error, Toast.LENGTH_SHORT).show();
                                loader.dismiss();
                            }

                        }
                    });
                }


            }
        });
    }
}




