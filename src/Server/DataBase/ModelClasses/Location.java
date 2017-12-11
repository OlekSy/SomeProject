package Server.DataBase.ModelClasses;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="location")
public class Location extends Model {

    private int id_location;
    private String description;
    private String type;

    private Set<Character> characters = new HashSet<Character>(0);
    private Set<NPC> NPSs = new HashSet<NPC>(0);

    public Location() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Location", unique = true)
    public int getId_location() {
        return id_location;
    }

    public void setId_location(int id_location) {
        this.id_location = id_location;
    }

    @Column(name="Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "location")
    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "location")
    public Set<NPC> getNPSs() {
        return NPSs;
    }

    public void setNPSs(Set<NPC> NPSs) {
        this.NPSs = NPSs;
    }
}
