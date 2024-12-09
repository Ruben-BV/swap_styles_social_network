package dev.ruben.swap_styles_social_network.user;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
            return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId).orElse(null);
    }

    public User getUserByEmail(String emailAddress){
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.getEmailAddress().equalsIgnoreCase(emailAddress)) {
                return user;
            }
        }

        return null;
    }

    public User updateUser(User user) {

        String emailAddressToProve = user.getEmailAddress();

        User existingEmail = getUserByEmail(emailAddressToProve);

        if (existingEmail != null && existingEmail.getId() != user.getId()) {
            throw new IllegalArgumentException("Incorrect email address.");
        }

        return userRepository.save(user);
    }

    @Transactional
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}