
package com.example.ex0921_alertdialog;

import static android.graphics.Color.rgb;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

/**
 * this is the main activity it will show 5 buttons and each button opens a different alert dialog
 * @author Ofek Dafna
 * @version 1.0
 * @since 13.01.2025
 */
public class MainActivity extends AppCompatActivity
{
    AlertDialog.Builder text,textAndPic,singleButton,switchBg,operations,everyColor;
    LinearLayout main;
    Random rnd;
    int[] colors; //= ;
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

        main = findViewById(R.id.main);
        rnd = new Random();

        text = new AlertDialog.Builder(this);            //first button
        textAndPic = new AlertDialog.Builder(this);      // second button
        switchBg = new AlertDialog.Builder(this);        // third button
        operations = new AlertDialog.Builder(this);      // fourth button
        everyColor = new AlertDialog.Builder(this);      // fifth button



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
    //----------------------------------------------------------------------------------------------
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
    //----------------------------------------------------------------------------------------------
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
    //----------------------------------------------------------------------------------------------

    /**
     * this method will be called when the user clicks on the button
     * it allows the user to change the background color to green or to blue
     * @param view
     */
    public void switchBackground(View view)
    {
        switchBg.setTitle("switch background");
        switchBg.setMessage("choose your background color:");
        switchBg.setNegativeButton("blue", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                main.setBackgroundColor(Color.BLUE);
                dialog.cancel();
            }
        });
        //------------------------------------------------------------------------------------------
        switchBg.setPositiveButton("green", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                main.setBackgroundColor(Color.GREEN);
                dialog.cancel();
            }
        });
        AlertDialog showText = switchBg.create();
        showText.show();
    }
    //----------------------------------------------------------------------------------------------
    /**
     * the func will be called when the user clicks on the fourth button
     * it allows the user to to change the background color to a random color or leave
     * @param view 
     */
    public void changeBackground(View view)
    {
        operations.setTitle("Operations");
        operations.setMessage("Choose an operation:");
        //------------------------------------------------------------------------------------------
        operations.setNegativeButton("resetBackGround", new DialogInterface.OnClickListener()
        {

            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                main.setBackgroundColor(Color.WHITE);
                dialog.cancel();
            }
        });
        //------------------------------------------------------------------------------------------
        operations.setPositiveButton("changeBackGround", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                int red = rnd.nextInt(255);
                int green = rnd.nextInt(255);
                int blue = rnd.nextInt(255);
                main.setBackgroundColor(rgb(red, green, blue));
                dialog.cancel();
            }
        });
        //------------------------------------------------------------------------------------------
        operations.setNegativeButton("leave", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }

        });
        //------------------------------------------------------------------------------------------
        AlertDialog showText = operations.create();
        showText.show();
    }
    //----------------------------------------------------------------------------------------------

    /**
     * the func will be called when the user clicks on the fourth button
     * it allows the user to change the background color to a random color or reset it back to white or leave
     * @param view
     */
    public void theLastButton(View view)
    {
        everyColor.setTitle("this is the last alert dialog");
        everyColor.setMessage("Choose an operation:");
        //------------------------------------------------------------------------------------------
        everyColor.setNegativeButton("cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });
        //------------------------------------------------------------------------------------------
        everyColor.setNeutralButton("resetBackground", new DialogInterface.OnClickListener()
        {

            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                main.setBackgroundColor(Color.WHITE);
            }
        });
        //------------------------------------------------------------------------------------------
        everyColor.setPositiveButton("changeBackGround", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                int red = rnd.nextInt(255);
                int green = rnd.nextInt(255);
                int blue = rnd.nextInt(255);
                main.setBackgroundColor(rgb(red, green, blue));
                dialog.cancel();
            }
        });

    }

    public void credits(View view)
    {
        Intent intent = new Intent(this, credits.class);
        startActivity(intent);
    }
}