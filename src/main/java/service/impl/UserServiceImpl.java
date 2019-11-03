package service.impl;

import domain.entitiy.User;
import domain.model.binding.LoginBindingModel;
import domain.model.binding.UserBindingModel;
import org.hibernate.annotations.common.util.impl.Log;
import org.modelmapper.ModelMapper;
import repository.UserRepository;
import service.UserService;

import javax.inject.Inject;

public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  @Inject
  public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public void save(UserBindingModel user) {
    userRepository.save(modelMapper.map(user, User.class));
  }

  @Override
  public LoginBindingModel getUSerWithUsernameAndPassword(String username, String password) {
  return modelMapper.map(userRepository
      .getUserWithUsernameAndPassword(username, password), LoginBindingModel.class);
  }

  @Override
  public LoginBindingModel getUSerWithUsername(String username) {
    return modelMapper.map(userRepository.getUserWithUsername(username), LoginBindingModel.class);
  }
}
