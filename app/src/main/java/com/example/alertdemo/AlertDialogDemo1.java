package com.example.alertdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class AlertDialogDemo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_demo1);
    }

    AlertDialog.Builder builder;

    public  void onBtnShowAlertDialog(View view)
    {
        builder =new AlertDialog.Builder(AlertDialogDemo1.this);
        builder .setMessage("This is a simple Alert");
        builder.show();
    }

    public void onBtnShowAlertDialogWithBtns(View view)
    {
        builder =new AlertDialog.Builder(AlertDialogDemo1.this);
        builder .setIcon(R.drawable.icon_cancel);
        builder.setTitle("Added buttons to the Alert Box ");
        builder.setMessage("Msg :Do you want to cancel the game");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogDemo1.this,"You Click on YES...!!!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogDemo1.this, "You clicked on NO ..!!", Toast.LENGTH_SHORT).show();
            }
        });


        builder.show();
    }

    public  void onBtnAlertSingleChoiceListDialog(View view)
    {
    AlertDialog.Builder builder =new AlertDialog.Builder(this);

    builder.setIcon(R.drawable.icon_color);
    builder.setTitle(R.string.single_choice_dialog_name).setItems(R.array.pick_a_single_color, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            String[] choosenColor=getResources().getStringArray(R.array.pick_a_single_color);
            Toast.makeText(AlertDialogDemo1.this, "You Choose "+choosenColor[i], Toast.LENGTH_SHORT).show();
        }
    });

    builder.show();
}

    public void onADSingleChoiceRadioBtn(View view)
    {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);

    String[] chooseColors=getResources().getStringArray(R.array.pick_a_single_color);
        final String[] choosedColor = {"Red"};



    builder.setIcon(R.drawable.icon_color);
    builder.setTitle(R.string.single_choice_dialog_name)
        .setSingleChoiceItems(R.array.pick_a_single_color, 0, new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
          choosedColor[0] =chooseColors[i];
//        Toast.makeText(AlertDialogDemo1.this,"You have choosen "+chooseColor[i],Toast.LENGTH_SHORT).show();
//        dialogInterface.dismiss();
    }
});

builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Toast.makeText(AlertDialogDemo1.this,"You have choosen "+ choosedColor[0],Toast.LENGTH_SHORT).show();
            }
        });

    builder.show();

    }


    ArrayList<String> selectedItems;
    public void onADMultipleChoiceCheckBoxBtn(View view)
    {


         //get all item from R
        String[] allToppings= getResources().getStringArray(R.array.pick_a_multi_toppings);

        // here we track the selected items
        selectedItems = new ArrayList();

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.toppings);
        builder.setTitle(R.string.multi_choice_dialog_name);

        builder.setMultiChoiceItems(R.array.pick_a_multi_toppings, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                if (isChecked) {
                    // If the user checked the item, add it to the selected items
                    selectedItems.add(allToppings[which]);
                } else if (selectedItems.contains(which)) {
                    // Else, if the item is already in the array, remove it
                    selectedItems.remove(which);
                }
            }
        });

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String selectedList="";
                for (int k = 0;k<selectedItems.size()-1;k++){
                    selectedList += selectedItems.get(k)+" , ";
                }
                selectedList += selectedItems.get(selectedItems.size()-1)+" .";
                Toast.makeText(AlertDialogDemo1.this, "You have Selected \n "+selectedList, Toast.LENGTH_SHORT).show();
            }
        });

builder.show();
    }

    public  void onADCustomBtn(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater() ;
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout

        builder.setCancelable(false);
        builder.setView(inflater.inflate(R.layout.dialog_signin, null))
                // Add action buttons
                .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                        Toast.makeText(AlertDialogDemo1.this, "You have click on sign In", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       dialog.cancel();
                    }
                });
        builder.show();
    }
}