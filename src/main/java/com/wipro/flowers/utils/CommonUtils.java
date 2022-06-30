package com.wipro.flowers.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wipro.flowers.constant.URLConstant;
import com.wipro.flowers.model.FlowersDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

public class CommonUtils {

    private CommonUtils(){}

    public static List<FlowersDTO> convertStringToObject(String inputData) {
        Gson gson = new Gson();
        Type userListType = new TypeToken<List<FlowersDTO>>() {
        }.getType();
        return gson.fromJson(inputData, userListType);
    }

    public static String getDataFromRESTTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(URLConstant.RESOURCE_URL, String.class);
        return response.getBody();
    }
}

