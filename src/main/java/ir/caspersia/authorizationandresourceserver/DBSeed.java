package ir.caspersia.authorizationandresourceserver;

import ir.caspersia.authorizationandresourceserver.model.entity.OAuthClientDetails;
import ir.caspersia.authorizationandresourceserver.model.repository.OAuthClientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DBSeed {
    private final OAuthClientDetailsRepository OAuthClientDetailsRepository;
    private final BCryptPasswordEncoder        passwordEncoder;

    @Autowired
    public DBSeed(OAuthClientDetailsRepository OAuthClientDetailsRepository, @Lazy BCryptPasswordEncoder passwordEncoder) {
        this.OAuthClientDetailsRepository = OAuthClientDetailsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @EventListener
    @Transactional
    public void addClients(ContextRefreshedEvent event) throws CloneNotSupportedException {
        if (OAuthClientDetailsRepository.count() == 3)
            return;
        OAuthClientDetails OAuthClientDetails = new OAuthClientDetails("android_client"
                , passwordEncoder.encode("caspersia_android")
                , null
                , "read,write"
                , "password,refresh_token,authorization_code"
                , null
                , null
                , 3600
                , 3600*24*30
                , null
                , "true");
        OAuthClientDetailsRepository.save(OAuthClientDetails);

        OAuthClientDetails = new OAuthClientDetails("ios_client"
                , passwordEncoder.encode("caspersia_ios")
                , null
                , "read,write"
                , "password,refresh_token,authorization_code"
                , null
                , null
                , 3600
                , 3600*24*30
                , null
                , "true");
        OAuthClientDetailsRepository.save(OAuthClientDetails);

        OAuthClientDetails = new OAuthClientDetails("web_client"
                , passwordEncoder.encode("caspersia_web")
                , null
                , "read,write"
                , "password,refresh_token,authorization_code"
                , null
                , null
                , 3600
                , 3600*24*30
                , null
                , "true");
        OAuthClientDetailsRepository.save(OAuthClientDetails);
    }
}
