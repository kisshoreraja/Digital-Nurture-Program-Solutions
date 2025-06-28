package com.cts.mockito;

import java.util.Optional;

public interface UserRepository {
    Optional<String> findUserById(String userId);
}
