package backend.project4.moonlight_confession.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import java.util.Collection;
import java.util.Map;

public class CustomUser implements OAuth2User {
    private OAuth2User oauth2User;  // Delegate containing information from the OAuth2 provider
    private Long id;  // Application-specific ID
    private String email;  // User email
    private String name;  // User name

    public CustomUser(OAuth2User oauth2User) {
        this.oauth2User = oauth2User;
        this.email = oauth2User.getAttribute("email");  // Example of extracting an attribute
        this.name = oauth2User.getAttribute("name");  // Attributes vary by provider
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oauth2User.getAuthorities();
    }

    @Override
    public String getName() {
        return this.name;
    }

    // Additional getters and setters for custom properties
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
