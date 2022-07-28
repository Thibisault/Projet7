package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest extends TestCase {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GeneratorHelpService generatorHelpService;

    private void supprimerUserTestDansBDD(List<User> userList){
        while (userList.size() > 0){
            userRepository.delete(userList.get(0));
            userList.remove(0);
        }
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreerNewUser() {
        List<User> userList = generatorHelpService.generatorUserTest(2);
        List<Integer> userIdList = new ArrayList<>();

        for (User user : userList){
            userIdList.add(user.getId());
        }
        for (Integer id : userIdList) {
            assertNotNull(userService.chercherById(id));
        }
        this.supprimerUserTestDansBDD(userList);
    }

    @Test
    public void testChercherTouteUser() {
        int nombreDeGeneration = 2;
        int nombreTotalDeUserAvantAjout = userService.chercherTouteUser().size();
        List<User> userList = generatorHelpService.generatorUserTest(nombreDeGeneration);
        int nombreTotalDeUserApresAjout = userService.chercherTouteUser().size();
        assertEquals(nombreTotalDeUserAvantAjout + nombreDeGeneration, nombreTotalDeUserApresAjout);
        this.supprimerUserTestDansBDD(userList);
    }

    @Test
    public void testChercherById() {
        List<User> userList = generatorHelpService.generatorUserTest(2);
        List<Integer> userIdList = new ArrayList<>();

        for (User user : userList){
            userIdList.add(user.getId());
        }

        for (Integer id : userIdList) {
            assertEquals(userService.chercherById(id).getId(), id);
        }
        this.supprimerUserTestDansBDD(userList);
    }

    @Test
    public void testChercherByIdWithException() {
            List<User> userList = generatorHelpService.generatorUserTest(2);
            List<Integer> userIdList = new ArrayList<>();

            for (User user : userList){
                userIdList.add(user.getId());
            }

            for (Integer id : userIdList) {
                assertEquals(userService.chercherById(id).getId(), id);
            }
            this.supprimerUserTestDansBDD(userList);
    }

    @Test
    public void testSupprimerUser() {
        List<User> userList = generatorHelpService.generatorUserTest(2);
        List<Integer> userIdList = new ArrayList<>();

        for (User user : userList) {
            userIdList.add(user.getId());
        }
        for (Integer id : userIdList) {
            assertNotNull(userService.chercherById(id));
        }

        for (Integer id : userIdList) {
            User user = userService.chercherById(id);
            userService.supprimerUser(user);
            assertNull(userService.chercherById(id));
        }
    }

    @Test
    public void testChercherByUsername() {
            List<User> userList = generatorHelpService.generatorUserTest(2);
            List<String> listUsername = new ArrayList<>();

            for (User user : userList){
                listUsername.add(user.getUsername());
            }

            for (String userName : listUsername) {
                assertEquals(userService.chercherByUsername(userName).getUsername(), userName);
            }
            this.supprimerUserTestDansBDD(userList);
        }
    }
