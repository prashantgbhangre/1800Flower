package com.wipro.flowers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class FlowersDTO {

    private int userId;
    private int id;
    private String title;
    private String body;

}
