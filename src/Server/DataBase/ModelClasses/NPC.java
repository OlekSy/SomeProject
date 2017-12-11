package Server.DataBase.ModelClasses;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "npc")
public class NPC extends Model {

    private int id_NPC;
    private String Name;
    private String Type;

    private Location location;

    private Set<Quest> items = new HashSet<Quest>(0);

    public NPC() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_NPC", unique = true)
    public int getId_NPC() {
        return id_NPC;
    }

    public void setId_NPC(int id_NPC) {
        this.id_NPC = id_NPC;
    }

    @Column(name="Name")
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Column(name="Type")
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="location_id")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "npc")
    public Set<Quest> getItems() {
        return items;
    }

    public void setItems(Set<Quest> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return id_NPC +" "+ Name +" "+ Type + " " + location.getType();
    }
}
