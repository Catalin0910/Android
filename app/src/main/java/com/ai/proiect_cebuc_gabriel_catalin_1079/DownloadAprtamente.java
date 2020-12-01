package com.ai.proiect_cebuc_gabriel_catalin_1079;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class DownloadAprtamente {

    private static DownloadAprtamente instance;

    private DownloadAprtamente(){}


    public  static DownloadAprtamente getInstance() {
        if(instance == null){
            instance = new DownloadAprtamente();
        }
        return instance;
    }

    public void getApartmentData(final IApartement listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://api.mocki.io/v1/71a83960");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream stream = connection.getInputStream();
                    InputStreamReader streamReader =  new InputStreamReader(stream);
                    BufferedReader bufferedReader = new BufferedReader(streamReader);
                    StringBuilder stringBuilder =  new StringBuilder();
                    String line = "";
                    while((line =  bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    bufferedReader.close();
                    streamReader.close();
                    stream.close();
                    Log.v("read_remote", stringBuilder.toString());
                    listener.onSucces(parseApartamenteJson(stringBuilder.toString()));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    listener.onFailure(HttpURLConnection.HTTP_BAD_REQUEST, e);
                } catch (IOException e) {
                    e.printStackTrace();
                    listener.onFailure(HttpURLConnection.HTTP_INTERNAL_ERROR, e);
                }
            }
        }).start();
    }

    public ArrayList<Apartemnte> parseApartamenteJson(String result){
        ArrayList<Apartemnte> flats = new ArrayList<>();
        try {
            JSONObject resultJson = new JSONObject(result);
            JSONArray countriesJson =  resultJson.getJSONArray("apartamente");
            for(int i=0; i <countriesJson.length(); i++){
                JSONObject currentObject = countriesJson.getJSONObject(i);
                String titlu = currentObject.getString("titlul");
                String descriereScurta = currentObject.getString("descriereScurta");
                String pret = currentObject.getString("pret");
                String contact = currentObject.getString("dateContact");
                String descriereLunga = currentObject.getString("descriereLunga");
                Apartemnte apartamente = new Apartemnte(titlu, descriereScurta,descriereLunga, pret, contact);
                flats.add(apartamente);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return flats;
    }
}
