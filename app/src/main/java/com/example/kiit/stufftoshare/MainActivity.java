package com.example.kiit.stufftoshare;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    EditText name,password,upass,username;
    Button     reg,login;
    FirebaseAuth  firebaseAuth;
    String uname,upassword,strguname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        reg=findViewById(R.id.reg);
        //login Views
      /*  un=findViewById(R.id.un);
        upass=findViewById(R.id.upass);
        login=findViewById(R.id.login);*/


        firebaseAuth =FirebaseAuth.getInstance();
       //mAuth=FirebaseAuth.getInstance();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname=name.getText().toString().trim();
                upassword=password.getText().toString().trim();
                strguname=username.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(uname,upassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "good bro", Toast.LENGTH_SHORT).show();
                            //storing it to database not working

                            FirebaseDatabase.getInstance().getReference("users/").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "wrong entries", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        /*
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = un.getText().toString();
                pd = upass.getText().toString();
                mAuth.signInWithEmailAndPassword(email, pd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Intent i = new Intent(getApplicationContext(), Profile.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "bro reg first", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }

        });*/


    }



}



