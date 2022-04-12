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
import com.google.firebase.auth.FirebaseUser;

public class login_screen extends AppCompatActivity {
EditText username,password;
Button login;
TextView txtsignin;
private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login= findViewById(R.id.login);
        mAuth=FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        loginbutton();}});
        txtsignin=findViewById(R.id.txtsignin);
        txtsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signinintent();
            }
        });
    }

    private void signinintent() {
        Intent tosignin=new Intent(login_screen.this,signin.class);
        startActivity(tosignin);
    }
public void loginbutton()
{

            String uname,pass;
            uname=username.getText().toString();
            pass=password.getText().toString();
            if(uname.isEmpty()||pass.isEmpty())
                Toast.makeText(login_screen.this,"username or password is empty",Toast.LENGTH_SHORT).show();
            else
            {
                mAuth.signInWithEmailAndPassword(uname,pass).addOnCompleteListener(login_screen.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            loginAct(mAuth.getCurrentUser());

                        }
                        else
                            Toast.makeText(login_screen.this,"username or password is wrong",Toast.LENGTH_SHORT).show();
                    }
                });
            }
}

    private void loginAct(FirebaseUser cUser) {
        Toast.makeText(login_screen.this,"Succesful",Toast.LENGTH_SHORT).show();
        Intent dashboard=new Intent(login_screen.this, com.example.discus.dashboard.class);
        startActivity(dashboard);
    }
}