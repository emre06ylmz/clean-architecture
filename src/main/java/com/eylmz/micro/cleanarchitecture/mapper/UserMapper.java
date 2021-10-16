package com.eylmz.micro.cleanarchitecture.mapper;

import com.eylmz.micro.cleanarchitecture.api.request.UserRequest;
import com.eylmz.micro.cleanarchitecture.api.response.UserResponse;
import com.eylmz.micro.cleanarchitecture.dao.UserEntity;
import com.eylmz.micro.cleanarchitecture.service.dto.UserInputDTO;
import com.eylmz.micro.cleanarchitecture.service.dto.UserOutputDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserInputDTO mapRequestToInputDTO(UserRequest userRequest);

    UserEntity mapInputDTOToEntity(UserInputDTO userInputDTO);

    UserResponse mapOutputDTOToResponse(UserOutputDTO userOutputDTO);

    UserOutputDTO mapEntityToUserOutputDTO(UserEntity userEntity);

    List<UserOutputDTO> mapEntityListToOutputDTOList(List<UserEntity> userEntityList);

    List<UserResponse> mapOutputDTOListToResponseList(List<UserOutputDTO> userOutputDTOList);

}
