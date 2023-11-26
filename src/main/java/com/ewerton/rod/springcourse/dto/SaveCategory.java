package com.ewerton.rod.springcourse.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
public class SaveCategory implements Serializable {

    @NotBlank(message = "The name can't be empty")
    private String name;
}
