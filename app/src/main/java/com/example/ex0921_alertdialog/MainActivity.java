
package com.example.ex0921_alertdialog;

import android.content.DialogInterface;
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
    AlertDialog.Builder text,textAndPic,singleButton;

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
        singleButton = new AlertDialog.Builder(this);   // third button


    }

    /**
     * this method will be called when the user clicks on the button
     * it will show an alert dialog with text only
     * @param view
     */
    public void onlyTextDialog(View view)
    {
        text.setTitle("Alert:");
        text.setMessage("This is a simple alert dialog with only text. \npress anywhere around this dialog to continue...");
        AlertDialog showText = text.create();
        showText.show();
    }
    //------------------------------------------------------------------------------------------------------------------------
    /**
     * this method will be called when the user clicks on the button
     * it will show an alert dialog with text and a picture
     * @param view
     */
    public void textAndPicDialog(View view)
    {
        textAndPic.setTitle("attention:");
        textAndPic.setMessage("This is an alert dialog with a text and a picture.\npress anywhere around this alert dialog to continue...");
        textAndPic.setIcon(R.drawable.info_sign);
        AlertDialog showText = textAndPic.create();
        showText.show();
    }
    //------------------------------------------------------------------------------------------------------------------------
    /**
     * this method will be called when the user clicks on the button
     * it will show an alert dialog with text, an image and a button
     * @param view
     */
    public void alertDialogWithOnlyOneButton(View view)
    {
        singleButton.setTitle("hold on");
        singleButton.setMessage("please exit by clicking on the button");
        singleButton.setIcon(R.drawable.lock);
        singleButton.setNegativeButton("EXIT", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });
        AlertDialog showText = singleButton.create();
        showText.show();
    }
    //------------------------------------------------------------------------------------------------------------------------

}