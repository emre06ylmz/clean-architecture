package com.eylmz.micro.cleanarchitecture.api.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String name;
    private String surname;

}
