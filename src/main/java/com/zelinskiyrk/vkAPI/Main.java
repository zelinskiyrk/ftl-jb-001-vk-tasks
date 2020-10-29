package com.zelinskiyrk.vkAPI;

import com.zelinskiyrk.vkAPI.response.UserFollowers;
import com.zelinskiyrk.vkAPI.response.UserSubscriptions;
import com.zelinskiyrk.vkAPI.response.UsersSearch;
import lombok.NonNull;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static com.zelinskiyrk.vkAPI.VkService.*;

public class Main {
    public static void main(String[] args) throws IOException {

        VkApi api = VkService.getInstance().getJSONApi();

        Integer usersCount = 20;


        UsersSearch usersSearch = api.usersSearch(ACCESS_TOKEN, VERSION_API, usersCount).execute().body();

//  В цикле перебираем пользователей для вычисления количества подписок
        for (int i = 0; i < usersCount; i++) {
            System.out.println(usersSearch.getResponse().items.get(i).toString());

            String first_name = usersSearch.getResponse().items.get(i).first_name;
            Integer user_id = usersSearch.getResponse().items.get(i).id;

//  Добавляем задержку, так как VK выдает ошибку "Too many requests per second"
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            UserFollowers followersCount = api.userFollowers(ACCESS_TOKEN, VERSION_API, user_id).execute().body();

//  Добавляем задержку, так как VK выдает ошибку "Too many requests per second"
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            UserSubscriptions subscriptionCount = api.userSubscriptions(ACCESS_TOKEN, VERSION_API, user_id).execute().body();

//  Проверяем аккаунт на приватность, если закрытый - пропускаем
            if (usersSearch.getResponse().items.get(i).is_closed) {
                System.out.println("Closed profile");
            } else {

                Integer countOfFollowers = followersCount.getResponse().count;
                Integer countOfSubscriptionsGroups = subscriptionCount.getResponse().groups.count;
                Integer countOfSubscriptionsUsers = subscriptionCount.getResponse().users.count;

                System.out.println("The number of followers of the user " + first_name + ": " + countOfFollowers);
                System.out.println("The number of groups to which the user " + first_name + " is subscribed is :" + countOfSubscriptionsGroups);
                System.out.println("The number of users subscribed to by user " + first_name + " is subscribed is :" + countOfSubscriptionsUsers);

            }
            System.out.println("");


        }

    }
}
