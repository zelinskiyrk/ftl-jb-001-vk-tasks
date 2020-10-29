package com.zelinskiyrk.vkAPI.response;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class UserSubscriptions {

    @Getter
    @ToString
    public class Users{
        public int count;
        public List<Integer> items;
    }

    @Getter
    @ToString
    public class Groups{
        public int count;
        public List<Integer> items;
    }

    @Getter
    @ToString
    public class Response{
        public Users users;
        public Groups groups;
    }

    Response response;
}
