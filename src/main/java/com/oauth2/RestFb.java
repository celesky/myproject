package com.oauth2;

import com.restfb.DefaultFacebookClient;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.types.User;

/**
 * Created by pan on 16/11/14.
 */
public class RestFb {
    public static void main(String[] args) {
        FacebookClient facebookClient = new DefaultFacebookClient();
        User user = facebookClient.fetchObject("me", User.class);

    }
}
