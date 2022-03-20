package com.a4ano.aps.aps_app.controller;

import android.util.Log;
import android.widget.TextView;

import com.a4ano.aps.aps_app.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class Conexao {
    public static final String INPE = "http://servicos.cptec.inpe.br/XML/cidade/586/previsao.xml";
    public static final int CONNECTION_TIMEOUT = 5000;//tempo maximo para conexao no servico
    public static final int READ_TIMEOUT = 5000;//tempo maximo para resposta de leitura do servico

    boolean conectado;
    HttpURLConnection conn; //devolve msgs de retorno do HTTP...
    URL url = null;

    {
        try {
            url = new URL(INPE);
            conn = (HttpURLConnection) url.openConnection();
            conectado = true;
        } catch (MalformedURLException e) {
            Log.e("Web Services", "MalformedURLException - " + e.getMessage());
            conectado = false;
        } catch (Exception erro) {
            Log.e("Web Services", "Exception - " + erro.getMessage());
            conectado = false;
        }

    }

}
