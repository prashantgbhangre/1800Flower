package com.wipro.flowers.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wipro.flowers.model.FlowersDTO;

import java.lang.reflect.Type;
import java.util.List;

public class CommanUtils {

    public static List<FlowersDTO> convertStringToObject(String inputData){
        Gson gson = new Gson();
        Type userListType = new TypeToken<List<FlowersDTO>>(){}.getType();
        List<FlowersDTO> flowerList = gson.fromJson(inputData, userListType);
        return  flowerList;
    }
}

