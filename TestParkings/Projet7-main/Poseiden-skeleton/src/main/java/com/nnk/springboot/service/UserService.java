package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.security.SecurityConfig;
import com.nnk.springboot.security.SimpleGrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    SecurityConfig securityConfig = new SecurityConfig();

    private final UserRepository userRepositorys;

    @Autowired
    public UserService(UserRepository userRepository, UserRepository userRepositorys) {
        this.userRepository = userRepository;
        this.userRepositorys = userRepositorys;
    }


    /**
     * Enregeistrer un bidList Dans la base de données
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
        List<User> userList = new ArrayList<>();
        userList = userRepository.findAll();
        return userList;
    }

    public User chercherById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void supprimerBidList(User user) {
        userRepository.delete(user);
    }

    public User seConnecter (String userName, String password) throws Exception {
        User user = this.chercherByUsername(userName);
        if (securityConfig.passwordEncoder().matches(password, user.getPassword())){
            return user;
        }
        throw new Exception("Le mot de passe ne correspond pas au pseudo");
    }

    public User chercherByUsername (String username){
        return userRepository.findByUsername(username).orElse(null);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        return userRepository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


}
