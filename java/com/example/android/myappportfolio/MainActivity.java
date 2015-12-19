package com.example.android.myappportfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toaster toaster = new Toaster();

        Button button1 = (Button) findViewById(R.id.button1); button1.setOnClickListener(toaster);
        Button button2a = (Button) findViewById(R.id.button2a); button2a.setOnClickListener(toaster);
        Button button2b = (Button) findViewById(R.id.button2b); button2b.setOnClickListener(toaster);
        Button button3 = (Button) findViewById(R.id.button3); button3.setOnClickListener(toaster);
        Button button4 = (Button) findViewById(R.id.button4); button4.setOnClickListener(toaster);
        Button button5 = (Button) findViewById(R.id.button5); button5.setOnClickListener(toaster);
    }

    class Toaster implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v instanceof Button)
                Toast.makeText(getApplicationContext(), "This button wil launch "+((Button)v).getText(), Toast.LENGTH_SHORT).show();
        }
    }
}