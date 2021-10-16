package com.eylmz.micro.cleanarchitecture.api.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private int id;
    private String name;
    private String surname;

}