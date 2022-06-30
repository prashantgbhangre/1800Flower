package com.wipro.flowers.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UpdateUserDTO {

    private int position;
    private String body;
    private String title;

}
