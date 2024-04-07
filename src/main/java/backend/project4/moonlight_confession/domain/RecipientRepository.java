package backend.project4.moonlight_confession.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RecipientRepository  extends CrudRepository <Recipient, Long>{
    List<Recipient> findByFirstName (String firstName);
}
