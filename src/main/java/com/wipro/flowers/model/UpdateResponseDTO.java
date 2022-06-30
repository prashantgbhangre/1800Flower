package com.wipro.flowers.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class UpdateResponseDTO {
    private List<FlowersDTO> data;
    private int status;
    private String errorMessage;
}
