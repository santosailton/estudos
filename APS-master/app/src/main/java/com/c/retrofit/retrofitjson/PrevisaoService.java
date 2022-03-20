package com.c.retrofit.retrofitjson;

import com.c.retrofit.retrofitjson.model.Cidade;
import com.c.retrofit.retrofitjson.model.Previsao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PrevisaoService {
    @GET("{nome}/json")
    Call<Cidade> buscarCidade(@Path("nome") String cidade);

    @GET("{previsao}/json")
    Call<Cidade> buscarPrevisao(@Path("previsao") List<Previsao> previsao);

    @GET("{previsao}/json")
    Call<Previsao> buscarPrevisaoHoje(@Path("previsao") Previsao previsao);
}
