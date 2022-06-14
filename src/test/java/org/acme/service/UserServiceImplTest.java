package org.acme.service;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import org.acme.model.User;
import org.acme.repository.UserRepository;
import org.acme.resource.request.CreateUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@QuarkusTest
@QuarkusTestResource(value = H2DatabaseTestResource.class, parallel = true)
public class UserServiceImplTest {

    @Inject
    UserServiceImpl userService;

    @Inject
    UserRepository userRepository;

    @Test
    @Transactional
    public void canCreateUserTest() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstName("Test");
        createUserRequest.setLastName("Ouna Sacko");
        createUserRequest.setPassword("qwJ12?=");
        createUserRequest.setMobileNo("+254712345576");
        createUserRequest.setEmail("Test@co.ke");

        User user = null;
        try {
            user = userService.createUser(createUserRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        User newUser = userRepository.findById(user.getUserId());

        Assertions.assertEquals(newUser.getFirstName(), "Test");
        Assertions.assertEquals(newUser.getLastName(), "Ouna Sacko");
        Assertions.assertEquals(newUser.getPassword(), "qwJ12?=");
        Assertions.assertEquals(newUser.getMobileNo(), "+254712345576");
        Assertions.assertEquals(newUser.getEmail(), "Test@co.ke");
    }

    @Test
    public void canGetUserByIdTest() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstName("Aphy");
        createUserRequest.setLastName("Sacko");
        createUserRequest.setPassword("qwJ12?4TK");
        createUserRequest.setMobileNo("+254712345214");
        createUserRequest.setEmail("Aphy@co.ke");
        User searchUser;
        try {
            searchUser = userService.createUser(createUserRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        User users = userRepository.findById(searchUser.getUserId());

        Assertions.assertSame(users.getUserId(), users.getUserId());
        Assertions.assertEquals(searchUser.getEmail(), "Aphy@co.ke");
    }

    @Test
    @Transactional
    public void canUpdateUserTest(){
        CreateUserRequest request = new CreateUserRequest();
        request.setFirstName("Achamin");
        request.setLastName("Nesh");
        request.setPassword("Aka32?.32K");
        request.setEmail("acha @ gmail.com");
        request.setMobileNo("+254713542321");
        try {
            User saveUser = userService.createUser(request);
            User updateUser = userRepository.findById(saveUser.getUserId());
            updateUser.setPassword("A54/=Wak");
            updateUser.setFirstName("Mella");
            userService.updateUser(updateUser);

            Assertions.assertEquals(updateUser.getPassword(),"A54/=Wak");
            Assertions.assertEquals(updateUser.getFirstName(), "Mella");
            Assertions.assertEquals(updateUser.getLastName(), "Nesh");
            Assertions.assertEquals(updateUser.getMobileNo(), "+254713542321");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Transactional
    public void canDeleteUserTest(){
        CreateUserRequest request = new CreateUserRequest();
        request.setFirstName("time");
        request.setLastName("Wanyonyi");
        request.setPassword("KkH12?");
        request.setMobileNo("+254745390087");
        request.setEmail("Timwn21 @ co.ke");

        User createUser;
        try {
            createUser = userService.createUser(request);
            userService.delete(createUser.getUserId());
            Optional<User> getUser = userRepository.findByIdOptional(createUser.getUserId());
            Assertions.assertNull(getUser.isPresent());
            Assertions.assertNull(getUser.get().getUserId());
            //Assertions.assertNull(getUser.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void canListAllUsersTest(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFirstName("Test");
        createUserRequest.setLastName("Ouna Sacko");
        createUserRequest.setPassword("qwJ12?=");
        createUserRequest.setMobileNo("+254712345576");
        createUserRequest.setEmail("Test@co.ke");

        User user = null;
        try {
            user = userService.createUser(createUserRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        CreateUserRequest createUser2Request = new CreateUserRequest();
        createUser2Request.setFirstName("Kyler ");
        createUser2Request.setLastName("Vyes Bissouma");
        createUser2Request.setPassword("qKRw32Q?");
        createUser2Request.setMobileNo("+254712345763");
        createUser2Request.setEmail("Testcase1@gmail.com");

        User user2 = null;
        try {
            user2 = userService.createUser(createUser2Request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        CreateUserRequest createUser3Request = new CreateUserRequest();
        createUser3Request.setFirstName("Test 3name");
        createUser3Request.setLastName("Ous Sako Sanku");
        createUser3Request.setPassword("qwJ10945hg?=");
        createUser3Request.setMobileNo("+254778645576");
        createUser3Request.setEmail("Test@gmail.com");

        User user3 = null;
        try {
            user3= userService.createUser(createUser3Request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<User> list = userService.findUsers();
        Assertions.assertEquals(list.size(), 3);
    }
}
