package com.zelinskiyrk.vkAPI;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class VkService {

    private Retrofit retrofit;
    private static VkService instance;
    private static final String BASE_URL = "https://api.vk.com/method/";
    public static final String ACCESS_TOKEN = "2ab9539a0339be440697cfcb387340dec9295344ef491018b5a40c5562b6c09bce901d65b9587d14e0808";
    public static final String VERSION_API = "5.124";

    private VkService() {

        retrofit = new Retrofit.Builder()
//                .client(createOKHTTPClient())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static VkService getInstance() {
        if (instance == null) {
            instance = new VkService();
        }
        return instance;
    }

    public VkApi getJSONApi() {
        return retrofit.create(VkApi.class);
    }

    private OkHttpClient createOKHTTPClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

}
