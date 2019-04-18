package ir.caspersia.authorizationandresourceserver.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String           username;
    @Column(unique = true)
    private String           email;
    @JsonIgnore
    private String           password;
    @JsonIgnore
    private Boolean          isAccountNonLocked = true;
    @JsonIgnore
    private Boolean          isAccountNonExpired = true;
    @JsonIgnore
    private Boolean          isEnabled = true;
    private String firstName;
    private String lastName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;
}
