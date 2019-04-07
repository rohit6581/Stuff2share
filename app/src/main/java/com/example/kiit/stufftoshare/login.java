package com.example.kiit.stufftoshare;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    EditText uemail,upass;
    Button   login;
    String  email,pd;
    FirebaseAuth mAuth;
    TextView sgnup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uemail=findViewById(R.id.uemail);
        upass=findViewById(R.id.upass);
        login=findViewById(R.id.login);
        sgnup=findViewById(R.id.sgnup);

        mAuth=FirebaseAuth.getInstance();

        sgnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itnt=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(itnt);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = uemail.getText().toString();
                pd = upass.getText().toString();
                mAuth.signInWithEmailAndPassword(email, pd).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(login.this, "User Identified", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(login.this, "register first", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }

        });
    }
}
