package backend.project4.moonlight_confession.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RelationshipRepository extends CrudRepository <Relationship, Long>{
    List<Relationship> findByName(String name);
}
