package com.zelinskiyrk.vkAPI.response;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class UserFollowers {

    @Getter
    @ToString
    public class Response{
        public int count;
        public List<Integer> items;
    }

    public Response response;

}
