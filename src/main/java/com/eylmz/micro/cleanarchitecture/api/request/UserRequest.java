package com.eylmz.micro.cleanarchitecture.api.request;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank
    @Max(50)
    private String name;

    @NotBlank
    @Max(50)
    private String surname;

}
