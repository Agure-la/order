package org.acme.service;

import org.acme.model.UserRole;
import org.acme.model.Users;
import org.acme.repository.UserRepository;
import org.acme.repository.UserRoleRepository;
import org.hibernate.DuplicateMappingException;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl {

    @Inject
    UserRepository userRepository;
    @Inject
    UserRoleRepository userRoleRepository;

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

    public List<Users> findAllUsers(){
        return (List<Users>) userRepository.findAll();
    }

    public String hash(String originalString) {
       return originalString;
    }

    public Optional<Users> findUser(Integer userId) {
        return userRepository.find("id", userId).firstResultOptional();
    }

    @Transactional
    public Users updateUser(Users users) {
        final Users users1 = userRepository.getEntityManager().merge(users);
        userRepository.persistAndFlush(users1);
        return users1;
    }

    public Optional<Users> delete(Integer userId) {
        final Optional<Users> user1 = findUser(userId);
        if (user1.isPresent()){
            final Users users = user1.get();
            users.setEmail("");
            userRepository.persistAndFlush(users);
        }
        return user1;
    }

    public void UpdateUserPassword(Integer userId, String currentPassword, String newPassword) {

        final Optional<Users> user = findUser(userId);
        final Users secondUser = user.get();
        if (secondUser.getPassword().equals(hash(currentPassword))){
            secondUser.setPassword(hash(newPassword));
            userRepository.persistAndFlush(secondUser);
        }
    }

    public Optional<UserRole> findRole(String userRole) {
        return userRoleRepository.findByName(userRole);
    }

    public Optional<Users> findUser(String email) {
        return userRepository.find("Email", email).firstResultOptional();
    }
}
