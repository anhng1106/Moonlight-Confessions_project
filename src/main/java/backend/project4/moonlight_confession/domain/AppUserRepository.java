package backend.project4.moonlight_confession.domain;

import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository <AppUser, Long> {
        AppUser findByUsername(String username);
}
