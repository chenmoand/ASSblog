package com.brageast.blog.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Setting {

    public static final String Client_Secret = "7b17a3aae019be56709b1ba28bbfde9f70c8941d";
    public static final String Client_Id = "98e07a1e606d561ed02a";
    public static final String GITHUB_API_Access_Token = "https://github.com/login/oauth/access_token";


    public static final String Client =
            GITHUB_API_Access_Token +
            "?client_secret="+ Client_Secret
            +"&client_id=" + Client_Id + "&code="
            ;
    public static final String GITHUB_API_USER = "https://api.github.com/user?access_token=";

    public static final String USER_API = "https://api.github.com/users/";
}
