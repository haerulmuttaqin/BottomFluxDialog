package com.haerul.bottomfluxdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /*INFO*/
        findViewById(R.id.infoDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                BottomFluxDialog.infoDialog(MainActivity.this)
                        .setTextTitle("Info Title")
                        .setTextMessage("This is a info message")
                        .setImageDialog(R.drawable.ic_dialog_info)
                        .setInfoButtonText("CLOSE")
                        .show();
                
            }
        });

        /*ALERT*/
        findViewById(R.id.alertDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomFluxDialog.alertDialog(MainActivity.this)
                        .setTextTitle("Alert Title")
                        .setTextMessage("This is a alert message")
                        .setImageDialog(R.drawable.ic_dialog_alert)
                        .setAlertButtonText("OK")
                        .setAlertListener(new BottomFluxDialog.OnAlertListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(MainActivity.this, "Button Clicked!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

            }
        });

        /*CONFIRM*/
        findViewById(R.id.confirmDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomFluxDialog.confirmDialog(MainActivity.this)
                        .setTextTitle("Confirm Title")
                        .setTextMessage("This is a confirm message")
                        .setImageDialog(R.drawable.ic_dialog_confirm)
                        .setLeftButtonText("CANCEL")
                        .setRightButtonText("OK")
                        .setConfirmListener(new BottomFluxDialog.OnConfirmListener() {
                            @Override
                            public void onLeftClick() {
                                Toast.makeText(MainActivity.this, "Left Button Clicked!", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onRightClick() {
                                Toast.makeText(MainActivity.this, "Right Button Clicked!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

            }
        });

        /*CONFIRM*/
        findViewById(R.id.openBrowser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://github.com/haerulmuttaqin";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
    }
}