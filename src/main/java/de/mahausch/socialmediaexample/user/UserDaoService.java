package de.mahausch.socialmediaexample.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component class UserDaoService {

    @Autowired private UserRepository userRepository;

    List<User> findAll() {
        return userRepository.findAll();
    }

    User save(User user) {
        return userRepository.save(user);
    }

    Optional<User> findOne(int id) {
        return userRepository.findById(id);
    }

    void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
