package com.zelinskiyrk.vkAPI.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UsersSearch {

    @Getter
    @Setter
    @ToString
    public class Item{
        public String first_name;
        public int id;
        public String last_name;
    }

    @Getter
    @Setter
    @ToString
    public class Response{
        public int count;
        public List<Item> items;
    }

    Response response;


}
