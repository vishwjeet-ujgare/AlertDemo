package com.example.alertdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnDialogFragment(View view)
    {
StartGameDialogFragment dialogFragment=new StartGameDialogFragment();
dialogFragment.show(getSupportFragmentManager(),"Hello");

    }


    public void onClickADExBtn(View view)
    {
        Intent intent=new Intent(this, AlertDialogDemo1.class);
        startActivity(intent);
    }

}