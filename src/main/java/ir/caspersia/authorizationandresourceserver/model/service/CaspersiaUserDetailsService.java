package ir.caspersia.authorizationandresourceserver.model.service;

import ir.caspersia.authorizationandresourceserver.model.entity.CasperisaUserPrincipal;
import ir.caspersia.authorizationandresourceserver.model.entity.User;
import ir.caspersia.authorizationandresourceserver.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CaspersiaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CaspersiaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
        if (user == null)
            throw new UsernameNotFoundException(s);
        return new CasperisaUserPrincipal(user);
    }
}
