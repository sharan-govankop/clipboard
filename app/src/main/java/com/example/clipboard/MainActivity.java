package com.example.clipboard;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.EditText;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ClipboardManager cbm;
    ClipData cd;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editText1);
        e2 = findViewById(R.id.editText2);
        cbm=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
    }
    public void copy(View V){
        String text = e1.getText().toString();
        cd = ClipData.newPlainText("text",text);
        cbm.setPrimaryClip(cd);

    }
    public void paste(View V){
        ClipData cd2 = cbm.getPrimaryClip();
        ClipData.Item item = cd2.getItemAt(0);
        String copied = item.getText().toString();
        e2.setText(copied);
    }
}