package com.eylmz.micro.cleanarchitecture.service;

import com.eylmz.micro.cleanarchitecture.service.dto.UserInputDTO;
import com.eylmz.micro.cleanarchitecture.service.dto.UserOutputDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    UserOutputDTO addUser(UserInputDTO userInputDTO);
    UserOutputDTO updateUser(int id, UserInputDTO userInputDTO);
    UserOutputDTO deleteUser(int id);
    List<UserOutputDTO> listUsers();
    UserOutputDTO getUserById(int id);
}
