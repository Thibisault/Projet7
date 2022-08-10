package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.domain.UserType;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.security.SecurityConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Transactional
public class UserService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    UserRepository userRepository;

    @Autowired
    LoginService loginService;

    SecurityConfig securityConfig = new SecurityConfig();


    /**
     * Permet d'update un User dans BDD sans avoir à changer le mot de passe
     * @param id
     * @param user
     */
    public void updateUserSansChangerMDP(Integer id, User user){
        if(user.getPassword().equals("")) {
            logger.info("Action udpate no change password if password is empty User");
            User userBdd = userRepository.findById(id).orElse(null);
            user.setPassword(userBdd.getPassword());
        } else {
            logger.info("Action udpate no change password if password is complete User");
            loginService.encrypterPassword(user, id);
        }
        userRepository.save(user);
    }

    /**
     * Enregeistrer un User Dans la base de données
     *
     * @param user
     */
    public void creerNewUser(User user) {
        user.setUserType(UserType.LOCAL);
        logger.info("Action create new User");
        userRepository.save(user);
    }

    /**
     * Récuperer tout les User
     *
     * @return
     */
    public List<User> chercherTouteUser() {
        List<User> userList;
        userList = userRepository.findAll();
        logger.info("Action find all User");
        return userList;
    }

    /**
     * Permet de chercher un User dans la BDD grâce à son UserId
     * @param userId
     * @return
     */
    public User chercherById(Integer userId) {
        logger.info("Action find byId User");
        return userRepository.findById(userId).orElse(null);
    }

    /**
     * Permet de chercher un User dans la BDD gràce à son userId en passant l'exception
     * @param userId
     * @return
     */
    public User chercherByIdWithException(Integer userId) {
        logger.info("Action find ByIdWithException User");
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
    }

    /**
     * Permet de supprimer un User dans la base de données
     * @param user
     */
    public void supprimerUser(User user) {
        logger.info("Action delete User");
        userRepository.delete(user);
    }

    /**
     * Permet de se connecter à l'application en vérifiant le mot de passe crypté
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    public User seConnecter (String userName, String password) throws Exception {
        User user = this.chercherByUsername(userName);
        if (securityConfig.passwordEncoder().matches(password, user.getPassword())){
            logger.info("Action conexion User");
            return user;
        }
        throw new Exception("Le mot de passe ne correspond pas au pseudo");
    }

    /**
     * Permet de trouver un User dans la BDD grâce à son userName
     * @param username
     * @return
     */
    public User chercherByUsername (String username){
        logger.info("Action find byUsername User");
        return userRepository.findByUsername(username).orElse(null);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        log.info("UserTypeLocal"+ userRepository.findByUsername(username).orElseGet(null).getUserType());
        return userRepository.findByUsernameAndUserType(username, UserType.LOCAL).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
