package com.zelinskiyrk.vkAPI;

import com.zelinskiyrk.vkAPI.response.UserFollowers;
import com.zelinskiyrk.vkAPI.response.UserSubscriptions;
import com.zelinskiyrk.vkAPI.response.UsersSearch;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

public interface VkApi {

    @GET("users.search")
    Call<UsersSearch> usersSearch(@Query("access_token") String access_token,
                                  @Query("v") String v, @Query("count") Integer count);

    @GET("users.getFollowers")
    Call<UserFollowers> userFollowers(@Query("access_token") String access_token,
                                      @Query("v") String v, @Query("user_id") Integer user_id);

    @GET("users.getSubscriptions")
    Call<UserSubscriptions> userSubscriptions(@Query("access_token") String access_token,
                                              @Query("v") String v, @Query("user_id") Integer user_id);

}
