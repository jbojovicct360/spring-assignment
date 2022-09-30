package com.jovan_bojovic.spring_assignment.api;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.*;

import java.io.IOException;

public class LanguageAPI {

    public String getTranslationFromApi(String lang) {
        OkHttpClient client = new OkHttpClient();
        Dotenv dotenv = null;
        dotenv = Dotenv.configure().load();
        String key = dotenv.get("API-KEY");

        MediaType mediaType = MediaType.parse("application/json");
        String value = "{\"from\": \"en_GB\",\"to\": \"" + lang + "\", \"data\": \"Hello World!\",\"platform\": \"api\"}";
        RequestBody body = RequestBody.create(mediaType, value);
        Request request = new Request.Builder()
                .url("https://lingvanex-translate.p.rapidapi.com/translate")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("X-RapidAPI-Key", key)
                .addHeader("X-RapidAPI-Host", "lingvanex-translate.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            String[] splitted = responseBody.split(":");
            splitted = splitted[2].split("\"");
            return splitted[1];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
