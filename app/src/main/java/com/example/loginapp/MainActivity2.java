package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    EditText e1, e2, e3, e4, e5, e6, e7;
    String s1, s2, s3, s4, s5, s6, s7;
    Db d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e1 = findViewById(R.id.ednam);
        e2 = findViewById(R.id.editTextTextPassword);
        e3 = findViewById(R.id.editTextTextPassword2);
        e4 = findViewById(R.id.editTextPhone);
        e5 = findViewById(R.id.aadhNumber);
        e6 = findViewById(R.id.idssn);
        e7 = findViewById(R.id.idnat);

        d = new Db(this);
    }

    public void register(View view) {
        s1 = e1.getText().toString();
        s2 = e2.getText().toString();
        s3 = e3.getText().toString();
        s4 = e4.getText().toString();
        s5 = e5.getText().toString();
        s6 = e6.getText().toString();
        s7 = e7.getText().toString();


        if (s2.equals(s3)) {

            d.savedata(s1, s2, s4, s5, s6,s7);



            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
            ArrayList a1 =new ArrayList();
            a1 = d.myname(s1);
           // new Handler().postDelayed(new Runnable() {
             //   @Override
            //    public void run() {
                    Intent i = new Intent(MainActivity2.this,MainActivity3.class);
                     i.putExtra("abcd",a1);


                   // i.putExtra("",)
                    startActivity(i);

            //    }
           // } ,2000);
        } 
        else {
            Toast.makeText(this, "invaild pw n cpw", Toast.LENGTH_SHORT).show();
        }

    }
}