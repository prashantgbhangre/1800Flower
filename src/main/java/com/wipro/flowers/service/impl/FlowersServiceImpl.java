package com.wipro.flowers.service.impl;

import com.wipro.flowers.constant.Constant;
import com.wipro.flowers.model.FlowersDTO;
import com.wipro.flowers.service.FlowersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FlowersServiceImpl implements FlowersService {


    @Override
    public List<FlowersDTO> countUniqueUser(List<FlowersDTO> flowerList) {
        return flowerList.stream()
                .filter(distinctByKey(FlowersDTO::getUserId))
                .collect(Collectors.toList());
    }

    @Override
    public List<FlowersDTO> updateUser(List<FlowersDTO> flowerList) {
        flowerList.get(Constant.POSITION).setBody(Constant.VALUE);
        flowerList.get(Constant.POSITION).setTitle(Constant.VALUE);
        return  flowerList;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
