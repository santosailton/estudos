package com.example.demo;

public class MainActivity {
    Button btnPesq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPesq = findViewById(R.id.btnBuscar);

        btnPesq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //busca previsão
            }
        });
    }
}
