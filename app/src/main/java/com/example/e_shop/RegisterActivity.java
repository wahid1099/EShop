package com.example.e_shop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class RegisterActivity extends AppCompatActivity {
    TextView alreadyhaveaccount;
    private FirebaseAuth mAuth;
    EditText singupemailidtext, singuppasswordedittext, singupnameeidttext, singupconfirmpassword;
    ProgressBar singupprogressbar;
    Button singupbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        alreadyhaveaccount = findViewById(R.id.singup_singin);
        singupemailidtext = findViewById(R.id.singup_emailid);
        singupnameeidttext = findViewById(R.id.singup_name);
        singuppasswordedittext = findViewById(R.id.singup_password);
        singupconfirmpassword = findViewById(R.id.singup_confirm_password);
        singupbtn = findViewById(R.id.singupbutton);
//        mAuth = FirebaseAuth.getInstance();
        alreadyhaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                //overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_form_right);
            }
        });
        singupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userregistration();

            }

        });


    }

    public void userregistration() {


        String mail = singupemailidtext.getText().toString().trim();
        String pass = singuppasswordedittext.getText().toString().trim();

        if (mail.isEmpty()) {

            singupemailidtext.setError("Enter an Email address");
            singupemailidtext.requestFocus();
            return;

        }

        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {

            singupemailidtext.setError("Enter a valid Email address");
            singupemailidtext.requestFocus();
            return;

        }

        if (pass.isEmpty()) {

            singuppasswordedittext.setError("Enter a password");
            singuppasswordedittext.requestFocus();
            return;

        }

        if (singuppasswordedittext.length() < 6) {
            singuppasswordedittext.setError("Minimum length of a password should be 6");
            singuppasswordedittext.requestFocus();
            return;
        }


        mAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    finish();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(RegisterActivity.this, "User is Already Register", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Error : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });


    }
}

