package ir.caspersia.authorizationandresourceserver.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "oauth_client_details")
public class OAuthClientDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;
    @Column(name = "client_id")
    private String  clientId;
    @Column(name = "client_secret")
    private String  clientSecret;
    @Column(name = "resource_ids")
    private String  resourceIds;
    private String  scope;
    @Column(name = "authorized_grant_types")
    private String  authorizedGrantTypes;
    @Column(name = "web_server_redirect_uri")
    private String  webServerRedirectURI;
    private String  authorities;
    @Column(name = "access_token_validity")
    private Integer accessTokenValidity;
    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValidity;
    @Column(name = "additional_information")
    private String  additionalInformation;
    @Column(name = "autoapprove")
    private String autoApprove;

    public OAuthClientDetails() {
    }

    public OAuthClientDetails(String clientId
            , String clientSecret
            , String resourceIds
            , String scope
            , String authorizedGrantTypes
            , String webServerRedirectURI
            , String authorities
            , Integer accessTokenValidity
            , Integer refreshTokenValidity
            , String additionalInformation
            , String autoApprove) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.resourceIds = resourceIds;
        this.scope = scope;
        this.authorizedGrantTypes = authorizedGrantTypes;
        this.webServerRedirectURI = webServerRedirectURI;
        this.authorities = authorities;
        this.accessTokenValidity = accessTokenValidity;
        this.refreshTokenValidity = refreshTokenValidity;
        this.additionalInformation = additionalInformation;
        this.autoApprove = autoApprove;
    }
}
