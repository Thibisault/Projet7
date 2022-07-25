package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

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
            User userBdd = userRepository.findById(id).orElse(null);
            user.setPassword(userBdd.getPassword());
        } else {
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
        return userList;
    }

    /**
     * Permet de chercher un User dans la BDD grâce à son UserId
     * @param userId
     * @return
     */
    public User chercherById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    /**
     * Permet de chercher un User dans la BDD gràce à son userId en passant l'exception
     * @param userId
     * @return
     */
    public User chercherByIdWithException(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
    }

    /**
     * Permet de supprimer un User dans la base de données
     * @param user
     */
    public void supprimerUser(User user) {
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
        return userRepository.findByUsername(username).orElse(null);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        return userRepository.findUserWithName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
