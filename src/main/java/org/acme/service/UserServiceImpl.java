package org.acme.service;

import org.acme.model.UserRole;
import org.acme.model.Users;
import org.acme.repository.UserRepository;
import org.acme.repository.UserRoleRepository;
import org.hibernate.DuplicateMappingException;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    @Inject
    UserRepository userRepository;
    @Inject
    UserRoleRepository userRoleRepository;


    @Override
    public Users createUser(String firstName, String lastName, String password, String mobileNo, String email) throws Exception {

        final Users users = new Users();
        users.setFirstName(firstName);
        users.setLastName(lastName);
        users.setPassword(hash(password));
        users.setMobileNo(mobileNo);
        users.setEmail(email);

        try {
            userRepository.persistAndFlush(users);
            return users;
        } catch (DuplicateMappingException e){
            throw new Exception(users.toString(), new Throwable(e));
        }
    }

    @Override
    public String hash(String originalString) {
       return originalString;
    }

    @Override
    public Optional<Users> findUser(Integer userId) {
        return userRepository.find("id", userId).firstResultOptional();
    }

    @Override
    @Transactional
    public Users updateUser(Users users) {
        final Users users1 = userRepository.getEntityManager().merge(users);
        userRepository.persistAndFlush(users1);
        return users1;
    }

    @Override
    public Optional<Users> delete(Integer userId) {
        final Optional<Users> user1 = findUser(userId);
        if (user1.isPresent()){
            final Users users = user1.get();
            users.setEmail("");
            userRepository.persistAndFlush(users);
        }
        return user1;
    }

    @Override
    public void UpdateUserPassword(Integer userId, String currentPassword, String newPassword) {

        final Optional<Users> user = findUser(userId);
        final Users secondUser = user.get();
        if (secondUser.getPassword().equals(hash(currentPassword))){
            secondUser.setPassword(hash(newPassword));
            userRepository.persistAndFlush(secondUser);
        }
    }

    @Override
    public Optional<UserRole> findRole(String userRole) {
        return userRoleRepository.findByName(userRole);
    }

    @Override
    public Users addUserToGroup(Users users, UserRole userRole) {
        final Users users1 = userRepository.getEntityManager().merge(users);
        final UserRole userGroup = userRoleRepository.getEntityManager().merge(userRole);
//        if (users1.getRoles() != null){
//            users1.
//        }
//
        return null;
    }

    @Override
    public Optional<Users> findUser(String email, String password) {
        return userRepository.find("Email = ?1 AND Password = ?2", email, hash(password))
                .firstResultOptional();
    }

    @Override
    public Optional<Users> findUser(String email) {
        return userRepository.find("Email", email).firstResultOptional();
    }
}
