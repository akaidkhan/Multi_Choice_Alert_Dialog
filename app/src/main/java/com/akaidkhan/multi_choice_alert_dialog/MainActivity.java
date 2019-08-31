package com.akaidkhan.multi_choice_alert_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final TextView textView = findViewById(R.id.txtView);
        Button showDialogBtn = findViewById(R.id.showsnackbarbtn);
        showDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // String array for alert dialog multi choice items
                String[] colorsArray = new String[]{"Black", "Orange", "Green", "Yellow", "White", "Purple"};
                // Boolean array for initial selected items
                final boolean[] checkedColorsArray = new boolean[]{
                        true, // Black checked
                        false, // Orange
                        false, // Green
                        true, // Yellow checked
                        false, // White
                        false  //Purple
                };
                // Convert the color array to list
                final List<String> colorsList = Arrays.asList(colorsArray);
                //setTitle
                builder.setTitle("Select colors");
                //set multichoice
                builder.setMultiChoiceItems(colorsArray, checkedColorsArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // Update the current focused item's checked status
                        checkedColorsArray[which] = isChecked;
                        // Get the current focused item
                        String currentItem = colorsList.get(which);
                        // Notify the current action
                        Toast.makeText(getApplicationContext(), currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
                    }
                });
                // Set the positive/yes button click listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when click positive button
                        textView.setText("Your preferred colors..... \n");
                        for (int i = 0; i<checkedColorsArray.length; i++){
                            boolean checked = checkedColorsArray[i];
                            if (checked) {
                                textView.setText(textView.getText() + colorsList.get(i) + "\n");
                            }
                        }
                    }
                });
                // Set the neutral/cancel button click listener
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when click the neutral button
                    }
                });
                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();

            }
        });


    }




}