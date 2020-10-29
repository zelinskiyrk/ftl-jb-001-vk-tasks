package com.zelinskiyrk.vkAPI;

import com.zelinskiyrk.vkAPI.response.UsersSearch;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static com.zelinskiyrk.vkAPI.VkService.*;

public class Main {
    public static void main(String[] args) throws IOException {

        VkApi api = VkService.getInstance().getJSONApi();

        UsersSearch usersSearch = api.usersSearch(ACCESS_TOKEN, VERSION_API, 1).execute().body();
        System.out.println(usersSearch.getResponse().items.toString());
        
    }
}
