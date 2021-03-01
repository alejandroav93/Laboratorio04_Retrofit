package com.example.retrofit_pokemon.retrofit2;

import java.sql.Time;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRest {

    final private Urls urls;

    public ApiRest(){
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(45, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(45, TimeUnit.SECONDS);
        RestAdapter restAdapter = RestAdapter.Builder()
                .setLogLevel(RestAdapter.Loglevel.FULL)
                .setEndPoint(Utils.END_POINT)
                .setConverter(new StringConverter2())
                .setClient(new OkClient(okHttpClient))
                .build();
        urls = restAdapter.create(Urls.class);
    }
    static class StringConverter2 implements Converter {
        public Object fromBody(TypedInput typedInput, Type type) {
            try {
                Scanner scanner = new Scanner(typedInput.in()).useDelimiter("\\A");
                return scanner.hasNext() ? scanner.next() : "";
            }
            catch(Exception ex){
                Objects.requireNonNull(ex.getCause()).printStackTrace();
                return null;
            }
        }
    }
    @Override
    public TypedOutput toBody(Object o){return null;}
    public Urls getService(){
        return urls;
    }

}
