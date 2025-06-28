package com.cts.mockito;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserGreeting(String userId) {
        return userRepository.findUserById(userId)
                .map(name -> "Hello, " + name + "!")
                .orElse("User not found");
    }
}
