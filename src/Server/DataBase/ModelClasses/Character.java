package Server.DataBase.ModelClasses;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "character", catalog = "projectdb")
public class Character extends Model {

    private int id_character;
    private String name;
    private int level;
    private int expirience;
    private String coordinates;

    private User user;
    private Quest quest;
    private Location location;

    private Set<Item> items = new HashSet<Item>(0);

    public Character() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Character", unique = true)
    public int getId_character() {
        return id_character;
    }

    public void setId_character(int id_character) {
        this.id_character = id_character;
    }
    @Column(name="Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="Level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    @Column(name="Expirience")
    public int getExpirience() {
        return expirience;
    }

    public void setExpirience(int expirience) {
        this.expirience = expirience;
    }

    @Column(name="Coordinates")
    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_User")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_Quest")
    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_Location")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "characters")
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
        return id_character +" "+ name +" "+ level + " " + expirience + " "+ user.getNickName() + " "+ quest.getDescription() + " "+ location.getType()+ " " +it;
    }
}
