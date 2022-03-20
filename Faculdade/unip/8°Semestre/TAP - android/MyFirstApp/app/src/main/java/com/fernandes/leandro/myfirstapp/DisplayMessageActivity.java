package com.fernandes.leandro.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent in = getIntent();//recupera intenção da outra act
        String msg = in.getExtras(MainActivity.MSG);
        TextView tv = new TextView(this);
        tv.setText(msg);
        tv.setTextSize(20);
        ViewGroup layout = findViewById(R.id.display_msg_activity);
        layout.add(tv);
    }
}
