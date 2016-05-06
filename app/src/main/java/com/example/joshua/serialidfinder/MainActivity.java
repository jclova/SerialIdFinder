package com.example.joshua.serialidfinder;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_log  =  (TextView)findViewById(R.id.tv_log);
        tv_log.setText(android.os.Build.SERIAL);

        Button btn_copy  =  (Button)findViewById(R.id.btn_copy);
        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("text", android.os.Build.SERIAL);
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Copied to clipboard", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                }
            }
        });


        Button btn_send  =  (Button)findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Serial Number");
                        intent.putExtra(Intent.EXTRA_TEXT, android.os.Build.SERIAL);
                        startActivity(intent);
                } catch (Exception e) {
                }
            }
        });

    }

}
