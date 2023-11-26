package com.ewerton.rod.springcourse.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
public class SaveProduct implements Serializable {

    @NotBlank(message = "The name can't be empty")
    private String name;
    @DecimalMin(value = "0.01", message = "The price must be greater than 0")
    private BigDecimal price;
    @Min(value = 1)
    private Long categoryId;
}
