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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText SingInEmaileditText, SingInPasseditText;
    TextView Regitrationactivity;
    Button loginbtn, loadbtn;
    TextView forgotpassword;
    private FirebaseAuth mAuth;
    private Button skiplogin;
    ProgressBar singInprogressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SingInEmaileditText = findViewById(R.id.nameeidtid);
        SingInPasseditText = findViewById(R.id.passwordsingin);
        loginbtn = findViewById(R.id.LoginButtonid);
        singInprogressbar = findViewById(R.id.singInprogress);
        forgotpassword = findViewById(R.id.forgotpasswordid);
        skiplogin=findViewById(R.id.skip_login);
        skiplogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent skiplogin=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(skiplogin);
            }
        });
        Regitrationactivity = findViewById(R.id.registerid);
        //FirebaseApp.initializeApp();
       //mAuth=FirebaseAuth.getInstance();
        //its registrion textview in login activity
        Regitrationactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
               // overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
            }
        });
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgot = new Intent(LoginActivity.this, Forgot_password.class);
                startActivity(forgot);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logindata();

            }

            private void logindata() {
                String email = SingInEmaileditText.getText().toString().trim();
                String password = SingInPasseditText.getText().toString().trim();
                if (email.isEmpty()) {
                    SingInEmaileditText.setError("Email can't be Empty");
                    SingInEmaileditText.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    SingInEmaileditText.setError("Enter a valid email address");
                    SingInEmaileditText.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    SingInPasseditText.setError("password can't be empty");
                    SingInPasseditText.requestFocus();
                    return;

                }
                if (password.length() > 6) {
                    SingInPasseditText.setError("Minimum lenth of password should be 6");
                    SingInPasseditText.requestFocus();
                    return;
                }
                singInprogressbar.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            singInprogressbar.setVisibility(View.GONE);
                            Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent1);
                         //   overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
                            // Sign in success, update UI with the signed-in user's information
                            // Log.d(TAG, "createUserWithEmail:success");
                            //  FirebaseUser user = mAuth.getCurrentUser();
                            ///   updateUI(user);
                            Toast.makeText(LoginActivity.this, "Succesfully Log in", Toast.LENGTH_SHORT).show();
                        } else {

                            Toast.makeText(LoginActivity.this, "Log in is Unsuccesfull", Toast.LENGTH_SHORT).show();
                            // If sign in fails, display a message to the user.
                            //  Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            // Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                            //      Toast.LENGTH_SHORT).show();
                            // updateUI(null);
                            /// Toast.makeText(SingupActivity.this, "Register is not succesfull", Toast.LENGTH_SHORT).show();

                        }

                    }
                });

            }
        });

    }
}