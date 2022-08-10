package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.security.SecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LoginService {

    Logger logger = LoggerFactory.getLogger(LoginService.class);


    SecurityConfig securityConfig = new SecurityConfig();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * premet de se connecter à l'application en vérifiant les mots de passes
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    public User seConnecter(String userName, String password) throws Exception {
        User user = (User) userService.loadUserByUsername(userName);
        if (securityConfig.passwordEncoder().matches(password, user.getPassword())) {
            return user;
        }
        logger.info("Action udpate with no password change user");
        throw new Exception("Le mot de passe ne correspond pas au pseudo");
    }

    /**
     * Permet de mettre à jour un User dans la base de données
     * @param user
     * @return
     */
    public User validerConnection (User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        logger.info("Action validate connection user");
        return user;
    }

    /**
     * Permet d'encrypter un mot de passe user dans la BDD
     * @param user
     * @param id
     * @return
     */
    public User encrypterPassword(User user, Integer id){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(id);
        logger.info("Action encrypt password user");
        return user;
    }

}