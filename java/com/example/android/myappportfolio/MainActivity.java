package com.example.android.myappportfolio;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


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
        public void onClick(View view) {
            if(view instanceof Button) {
                //Intent projectIntent = new Intent(view.getContext(), getActivityPackageName(((Button) view).getText().toString()));
                //view.getContext().startActivity(projectIntent);
                PackageManager manager = getPackageManager();
                String packageName = getActivityPackageName(((Button) view).getText().toString());
                Intent projectIntent = null;
                if(packageName!=null)   //launching contacts when package is null
                    projectIntent = manager.getLaunchIntentForPackage(packageName);
                if (null==projectIntent||projectIntent.equals("null")) //unimplemented projs
                    Toast.makeText(getApplicationContext(), "This button wil launch " + ((Button) view).getText(), Toast.LENGTH_SHORT).show();
                else {
                    projectIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                    projectIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //projectIntent.addCategory(Intent.CATEGORY_LEANBACK_LAUNCHER); //TV??
                    startActivity(projectIntent);
                }
            }
        }
        private String getActivityPackageName(String text) {
            Map<String,String> projMapping = new HashMap(){{
                put(getString(R.string.button1), "com.github.sumantics.p1moviesapp");
                put(getString(R.string.button2a), "barqsoft.footballscores");
                put(getString(R.string.button2b), "it.jaschke.alexandria");
            }};
            return projMapping.get(text);
        }
    }
}
