package lucas_ladeira.api_rest.service;

import lucas_ladeira.api_rest.domain.model.User;

public interface UserService {
    User findByID(Long id);

    User create(User userToCreate);
}
