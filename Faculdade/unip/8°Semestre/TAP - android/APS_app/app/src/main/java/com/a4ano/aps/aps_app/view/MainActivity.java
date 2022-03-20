package com.a4ano.aps.aps_app.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.a4ano.aps.aps_app.R;
import com.a4ano.aps.aps_app.controller.Conexao;

public class MainActivity extends AppCompatActivity {

    Button btnPesq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPesq = findViewById(R.id.btnBuscar);

        btnPesq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Conexao();
                //busca previsão
            }
        });
    }

}
