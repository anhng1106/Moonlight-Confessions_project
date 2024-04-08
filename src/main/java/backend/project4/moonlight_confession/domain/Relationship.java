package backend.project4.moonlight_confession.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long relationshipId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relationship")
	private List<Recipient> recipients;

    public Relationship() {}

    public Relationship (String name)
    {
        super();
        this.name = name;
    }

    public Relationship (Long relationshipId)
    {
        this.relationshipId = relationshipId;
    }

    public Long getId() {
        return this.relationshipId;
    }

    public void setId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipient> getRecipients() {
        return this.recipients;
    }

    public void setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
    }
    
}
