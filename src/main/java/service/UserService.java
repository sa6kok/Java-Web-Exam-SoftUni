package service;

import domain.entitiy.User;
import domain.model.binding.LoginBindingModel;
import domain.model.binding.UserBindingModel;

public interface UserService {
  void save(UserBindingModel user);
  LoginBindingModel getUSerWithUsernameAndPassword(String username, String password);
  LoginBindingModel getUSerWithUsername(String username);
}
