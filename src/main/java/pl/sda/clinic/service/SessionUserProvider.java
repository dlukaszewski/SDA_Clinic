package pl.sda.clinic.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.sda.clinic.model.User;
import pl.sda.clinic.repository.UserRepository;

import javax.transaction.Transactional;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionUserProvider  {
    @Autowired
    private UserRepository userRepository;
    private User user;


    public User getLoggedUser() {
        return userRepository.findById(user.getUsername()).get();
    }


    @Transactional
    public void saveLoggedUser(String username) {
        user = userRepository.findById(username).get();
    }
}

