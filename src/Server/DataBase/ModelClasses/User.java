package Server.DataBase.ModelClasses;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "user", catalog = "projectdb")
public class User extends Model {

    private int id_user;

    private String NickName = "";
    private String password = "";
    private String email = "";


    private Set<Character> characters = new HashSet<Character>(0);

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    public User(){}

    public User(int id_user)
    {
        this.id_user = id_user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user", unique=true)
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Column(name="NickName")
    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }
    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String ch ="";
        for (Character c:characters) {
            ch += c.getName()+", ";
        }
        return id_user +" "+ NickName +" "+ password + " " + email + " " +ch;
    }
}
