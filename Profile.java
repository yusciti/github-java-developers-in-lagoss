package com.example.yusuph.andela;

import static android.R.attr.name;

/**
 * Created by Yusuph on 13/09/2017.
 */
///create a base class to hold the informations about the profile
public class Profile {

    //profile variables
    private String username;
    private String img;
    private String url;

    //create a constructor
    public Profile(String username, String img, String url){

        this.img = img;
        this.url = url;
        this.username = username;
    }
//create a getters method so that it can be use to fetch informations
    public String getUsername(){
        return username;
    }
    public String getImage(){
        return img;
    }
    public String getUrl(){
        return url;
    }
}
