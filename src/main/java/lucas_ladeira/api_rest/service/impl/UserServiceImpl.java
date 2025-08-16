package lucas_ladeira.api_rest.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import lucas_ladeira.api_rest.domain.model.User;
import lucas_ladeira.api_rest.domain.repository.UserRepository;
import lucas_ladeira.api_rest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByID(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}