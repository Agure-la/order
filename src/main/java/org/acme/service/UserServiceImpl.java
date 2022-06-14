package org.acme.service;

import org.acme.model.UserRole;
import org.acme.model.User;
import org.acme.repository.UserRepository;
import org.acme.repository.UserRoleRepository;
import org.acme.resource.request.CreateUserRequest;
import org.hibernate.DuplicateMappingException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
public class UserServiceImpl {

    @Inject
    UserRepository userRepository;
    @Inject
    UserRoleRepository userRoleRepository;

    @Transactional
    public User createUser(CreateUserRequest createUserRequest) throws Exception {

        final User users = new User();
        users.setFirstName(createUserRequest.getFirstName());
        users.setLastName(createUserRequest.getLastName());
        users.setPassword(hash(createUserRequest.getPassword()));
        users.setMobileNo(createUserRequest.getMobileNo());
        users.setEmail(createUserRequest.getEmail());

        try {
            userRepository.persistAndFlush(users);
            return users;
        } catch (DuplicateMappingException e){
            throw new Exception(users.toString(), new Throwable(e));
        }
    }

//    public List<Users> findAllUsers(){
//        return (List<Users>) userRepository.findAll();
//    }

    public String hash(String originalString) {
       return originalString;
    }

    public Optional<User> findUser(Integer userId) {
        return userRepository.find("id", userId).firstResultOptional();
    }

    @Transactional
    public User updateUser(User users) {
        final User users1 = userRepository.getEntityManager().merge(users);
        userRepository.persistAndFlush(users1);
        return users1;
    }

    @Transactional
    public Optional<User>  delete(Integer userId) {
       // userRepository.delete(findUser(userId));
        final Optional<User> user1 = findUser(userId);
        if (user1.isPresent()){
            final User users = user1.get();
            users.setEmail("");
          //  userRepository.delete(users);
            userRepository.persistAndFlush(users);
        }
        return user1;
    }

    public void UpdateUserPassword(Integer userId, String currentPassword, String newPassword) {

        final Optional<User> user = findUser(userId);
        final User secondUser = user.get();
        if (secondUser.getPassword().equals(hash(currentPassword))){
            secondUser.setPassword(hash(newPassword));
            userRepository.persistAndFlush(secondUser);
        }
    }

    public Optional<UserRole> findRole(String userRole) {
        return userRoleRepository.findByName(userRole);
    }

    public Optional<User> findUser(String email) {
        return userRepository.find("Email", email).firstResultOptional();
    }

    public List<User> findUsers(){
        return userRepository.findAll().list();
    }
}
