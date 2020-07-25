package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText p,n;
    String r,s;
    Db d1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p = findViewById(R.id.editTextTextPersonName);
        n = findViewById(R.id.editTextTextPersonName2);
        d1 = new Db(this);
    }

    public void signup(View view) {
        Intent i = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(i);
    }

    public void signin(View view) {
        r = p.getText().toString();
        s = n.getText().toString();
        ArrayList a =new ArrayList();
        a = d1.myname(r);

        if (a.get(0).equals("Not Exits")){

            Toast.makeText(this, "Not Exits", Toast.LENGTH_SHORT).show();
        }
        else if (a.get(0).equals(s)){
            Intent in3 = new Intent(MainActivity.this,MainActivity3.class);
            in3.putExtra("abcd",a);
            startActivity(in3);
        }
        else{
            Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
        }

    }
}