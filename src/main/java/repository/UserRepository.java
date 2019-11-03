package repository;

import domain.entitiy.User;

public interface UserRepository {
   void save(User user);
   User getUserWithUsernameAndPassword(String username, String password);
   User getUserWithUsername(String username);
}
