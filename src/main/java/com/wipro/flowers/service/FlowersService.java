package com.wipro.flowers.service;

import com.wipro.flowers.model.FlowersDTO;
import com.wipro.flowers.model.UpdateResponseDTO;
import com.wipro.flowers.model.UpdateUserDTO;
import com.wipro.flowers.model.UserCountDTO;

import java.util.List;

public interface FlowersService {

    public UserCountDTO countUniqueUser(List<FlowersDTO> flowerList);
    public UpdateResponseDTO updateUser(List<FlowersDTO> flowerList, UpdateUserDTO updateUserDTO);

}
