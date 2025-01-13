
package com.example.ex0921_alertdialog;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * this is the main activity it will show 5 buttons and each button opens a different alert dialog
 * @author Ofek Dafna
 * @version 1.0
 * @since 13.01.2025
 */
public class MainActivity extends AppCompatActivity
{
    AlertDialog.Builder text,textAndPic;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        text = new AlertDialog.Builder(this);           //first button
        textAndPic = new AlertDialog.Builder(this);     // second button


    }

    public void onlyTextDialog(View view)
    {
        text.setTitle("Alert:");
        text.setMessage("This is a simple alert dialog with only text. \npress anywhere around this dialog to continue...");
        AlertDialog showText = text.create();
        showText.show();
    }

    public void textAndPicDialog(View view)
    {
        textAndPic.setTitle("attention:");
        textAndPic.setMessage("This is a simple alert dialog with a text and a picture.");
        textAndPic.setIcon(R.drawable.info_sign);
        AlertDialog showText = textAndPic.create();
        showText.show();
    }
}