package com.wipro.flowers.service.impl;

import com.wipro.flowers.constant.ErrorMessageConstant;
import com.wipro.flowers.constant.LoggingConstant;
import com.wipro.flowers.model.FlowersDTO;
import com.wipro.flowers.model.UpdateResponseDTO;
import com.wipro.flowers.model.UpdateUserDTO;
import com.wipro.flowers.model.UserCountDTO;
import com.wipro.flowers.service.FlowersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

@Service
public class FlowersServiceImpl implements FlowersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlowersServiceImpl.class);

    @Override
    public UserCountDTO countUniqueUser(List<FlowersDTO> flowerList) {
        Long count =  flowerList.stream()
                .filter(distinctByKey(FlowersDTO::getUserId))
                .count();
        LOGGER.info(LoggingConstant.RETURN_COUNT,count);
        return UserCountDTO.builder().userCount(count).build();
    }

    @Override
    public UpdateResponseDTO updateUser(List<FlowersDTO> flowerList, UpdateUserDTO updateUserDTO) {
        try {
            flowerList.get(updateUserDTO.getPosition()).setBody(updateUserDTO.getBody());
            flowerList.get(updateUserDTO.getPosition()).setTitle(updateUserDTO.getTitle());
            LOGGER.info(LoggingConstant.RETURN_UPDATE_SUCCESS);
            return UpdateResponseDTO.builder().data(flowerList).status(200).build();
        }catch (IndexOutOfBoundsException ex){
            LOGGER.error(LoggingConstant.RETURN_UPDATE_ERROR);
            return UpdateResponseDTO.builder().data(null).status(400).errorMessage(ErrorMessageConstant.INVALID_POSTION).build();
        }
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
