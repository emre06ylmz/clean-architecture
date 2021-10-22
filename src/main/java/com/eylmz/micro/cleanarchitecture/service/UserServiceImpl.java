package com.eylmz.micro.cleanarchitecture.service;

import com.eylmz.micro.cleanarchitecture.dao.UserEntity;
import com.eylmz.micro.cleanarchitecture.exception.EntityNotFoundException;
import com.eylmz.micro.cleanarchitecture.mapper.UserMapper;
import com.eylmz.micro.cleanarchitecture.repository.UserRepository;
import com.eylmz.micro.cleanarchitecture.service.dto.UserInputDTO;
import com.eylmz.micro.cleanarchitecture.service.dto.UserOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserOutputDTO addUser(UserInputDTO userInputDTO) {
        UserEntity userEntity = userMapper.mapInputDTOToEntity(userInputDTO);
        UserEntity insertedUserEntity = userRepository.save(userEntity);
        return userMapper.mapEntityToUserOutputDTO(insertedUserEntity);
    }

    @Override
    public UserOutputDTO updateUser(int id, UserInputDTO userInputDTO) {
        if(!userRepository.findById(id).isPresent()){
            throw new EntityNotFoundException("User not found with given id: " + id);
        }

        UserEntity userEntity = userMapper.mapInputDTOToEntity(userInputDTO);
        userEntity.setId(id);

        UserEntity updatedUserEntity = userRepository.save(userEntity);
        return userMapper.mapEntityToUserOutputDTO(updatedUserEntity);
    }

    @Override
    public UserOutputDTO deleteUser(int id) {
        Optional<UserEntity> deletedUserEntity = userRepository.findById(id);
        if(!deletedUserEntity.isPresent()){
            throw new EntityNotFoundException("User not found with given id: " + id);
        }

        userRepository.deleteById(id);
        return userMapper.mapEntityToUserOutputDTO(deletedUserEntity.get());
    }

    @Override
    public List<UserOutputDTO> listUsers() {
        return userMapper.mapEntityListToOutputDTOList(userRepository.findAll());
    }

    @Override
    public UserOutputDTO getUserById(int id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(!userEntity.isPresent()){
            throw new EntityNotFoundException("User not found with given id: " + id);
        }
        return userMapper.mapEntityToUserOutputDTO(userEntity.get());
    }
}
