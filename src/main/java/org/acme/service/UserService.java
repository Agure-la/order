package org.acme.service;

import org.acme.model.UserRole;
import org.acme.model.Users;

import java.util.Optional;

public interface UserService {

    Users createUser(String firstName, String lastName, String password, String mobileNo, String email) throws Exception;

    String hash(String hsh);

    Optional<Users> findUser(Integer userId);

    Users updateUser(Users users);

    Optional<Users> delete(Integer userId);

    void UpdateUserPassword(Integer userId, String currentPassword, String newPassword);

    Optional<UserRole> findRole(String userRole);

    Users addUserToGroup(Users users, UserRole userRole);

    Optional<Users> findUser(String email, String password);

    Optional<Users> findUser(String email);
}
