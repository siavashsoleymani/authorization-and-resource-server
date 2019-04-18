package ir.caspersia.authorizationandresourceserver.model.service.impl;

import ir.caspersia.authorizationandresourceserver.common.Messages;
import ir.caspersia.authorizationandresourceserver.exception.BadRequestException;
import ir.caspersia.authorizationandresourceserver.model.entity.User;
import ir.caspersia.authorizationandresourceserver.model.repository.RoleRepository;
import ir.caspersia.authorizationandresourceserver.model.repository.UserRepository;
import ir.caspersia.authorizationandresourceserver.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepoistory;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepoistory) {
        this.userRepository = userRepository;
        this.roleRepoistory = roleRepoistory;
    }

    @Override
    public User registerUser(User user) {
        if (user == null) throw new BadRequestException(Messages.BAD_REQUEST);
        validateEmail(user);
        if (user.getRoles() == null)
            user.setRoles(Arrays.asList(roleRepoistory.findByName("ROLE_USER")));
        return userRepository.save(user);
    }

    private void validateEmail(User user) {
        user.setEmail(user.getEmail().replaceAll(".", ""));
        User byEmail = userRepository.findByEmail(user.getEmail());
        if (byEmail != null)
            throw new BadRequestException(Messages.DUPLICATE_EMAIL);
        if (!VALID_EMAIL_ADDRESS_REGEX .matcher(user.getEmail()).find())
            throw new BadRequestException(Messages.WRONG_EMAIL_ADDRESS);
    }
}
