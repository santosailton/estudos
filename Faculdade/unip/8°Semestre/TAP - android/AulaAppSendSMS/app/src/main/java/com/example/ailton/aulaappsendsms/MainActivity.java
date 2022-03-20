package com.example.ailton.aulaappsendsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SmsManager objSmsManager;

    Button btnEnviar;
    EditText editSMSPara;
    EditText editSMSMensagem;

    String smsPara;
    String smsMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSMSPara = findViewById(R.id.editSMSPara);
        editSMSMensagem = findViewById(R.id.editSMSmensagem);

        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        smsPara = editSMSPara.getText().toString();
                        smsMensagem = editSMSMensagem.getText().toString();

                        try {
                            objSmsManager = SmsManager.getDefault();
                            objSmsManager.sendTextMessage(smsPara,null,
                                    smsMensagem,null,null);
                            Toast.makeText(getApplicationContext(),"SMS Enviado!",Toast.LENGTH_LONG).show();
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"Falha! SMS não enviado..", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
