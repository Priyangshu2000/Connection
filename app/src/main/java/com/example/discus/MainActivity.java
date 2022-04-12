package com.example.discus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //The code you want to run after the time is up
                FirebaseUser cUser=mAuth.getCurrentUser();
                if (cUser!=null)
                    loginAct(cUser);
                else
                {
                    Intent i=new Intent(MainActivity.this,login_screen.class);
                    startActivity(i);
                }

            }
        }, 2000);

    }
//    public void onStart(){
//        super.onStart();
//        FirebaseUser cUser=mAuth.getCurrentUser();
//        if (cUser!=null)
//            loginAct(cUser);
//        else
//        {
//            Intent i=new Intent(MainActivity.this,login_screen.class);
//            startActivity(i);
//        }

//    }
    private void loginAct(FirebaseUser cUser) {
        Intent dashboard=new Intent(MainActivity.this, com.example.discus.dashboard.class);
        startActivity(dashboard);
    }
}