package com.wipro.flowers.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class FlowersDTO {

    private int userId;
    private int id;
    private String title;
    private String body;

}
