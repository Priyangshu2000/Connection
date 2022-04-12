package com.example.discus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class signin extends AppCompatActivity {
TextView txtlogin;
Button signin;
EditText uname,umail,password;
FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        txtlogin=findViewById(R.id.txtlogin);
        signin=findViewById(R.id.signin);
        uname=findViewById(R.id.signinuname);
        password=findViewById(R.id.signinpassword);
        umail=findViewById(R.id.signemail);
        mAuth=FirebaseAuth.getInstance();
        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(signin.this,login_screen.class);
                startActivity(i);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebasesignin();
            }
        });

    }

    private void firebasesignin() {
        String name=uname.getText().toString(),email=umail.getText().toString(),pass=password.getText().toString();
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {Toast.makeText(signin.this,"Succesfully signed in",Toast.LENGTH_LONG).show();
                Intent loginpage=new Intent(com.example.discus.signin.this, login_screen.class);
                startActivity(loginpage);}
                else
                {
                    Toast.makeText(signin.this, "Authentication failed." + task.getException(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}