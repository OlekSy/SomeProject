package Server.DataBase.ModelClasses;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "item")
public class Item {

    private int id_item;
    private String description;
    private String type;
    private int price;

    private Set<Character> characters = new HashSet<Character>(0);
    private Set<Quest> quests = new HashSet<Quest>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Item", unique = true)
    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
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

    @Column(name="Price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "character_item", joinColumns = {@JoinColumn(name = "item_id")}, inverseJoinColumns = {@JoinColumn(name = "character_id")})
    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "items")
    public Set<Quest> getQuests() {
        return quests;
    }

    public void setQuests(Set<Quest> quests) {
        this.quests = quests;
    }

    @Override
    public String toString() {
        String ch ="";
        for (Character c:characters) {
            ch += c.getName()+", ";
        }
        return id_item +" "+ description +" "+ type + " " +ch;
    }
}
