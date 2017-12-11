package Client.DataBase.ModelClasses;

import javax.persistence.*;

@Entity
@Table(name= "FavoriteServer")
public class FavoriteServer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Server;

    private String Description;
    private String Address;

    public FavoriteServer() {}

    public int getId_Server() {
        return id_Server;
    }

    public void setId_Server(int id_Server) {
        this.id_Server = id_Server;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return id_Server +" "+ Description +" "+ Address;
    }
}
