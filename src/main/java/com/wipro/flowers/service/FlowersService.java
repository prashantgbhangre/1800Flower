package com.wipro.flowers.service;

import com.wipro.flowers.model.FlowersDTO;

import java.util.List;

public interface FlowersService {

    public List<FlowersDTO> countUniqueUser(List<FlowersDTO> flowerList);
    public List<FlowersDTO> updateUser(List<FlowersDTO> flowerList);

}
