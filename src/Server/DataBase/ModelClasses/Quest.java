package Server.DataBase.ModelClasses;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "quest", catalog = "projectdb")
public class Quest extends Model {

    private int id_quest;
    private String description;
    private int experiencePoints;

    private NPC npc;

    private Set<Character> characters = new HashSet<Character>(0);
    private Set<Item> items = new HashSet<Item>(0);

    public Quest() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Quest", unique = true)
    public int getId_quest() {
        return id_quest;
    }

    public void setId_quest(int id_quest) {
        this.id_quest = id_quest;
    }

    @Column(name="Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="ExperiencePoints")
    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "quest")
    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_NPC")
    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "quest_item", joinColumns = {@JoinColumn(name = "quest_id")}, inverseJoinColumns = {@JoinColumn(name = "item_id")})
    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        String it ="";
        for (Item i:items) {
            it += i.getType()+", ";
        }
        return id_quest +" "+ description +" "+ experiencePoints + " " + npc + " " + it;
    }
}
