package de.mahausch.socialmediaexample.user;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id @GeneratedValue private Integer id;

    @Size(min = 2, message = "Name should have at least two characters")
    private String user;

    @Past(message="Birthdate has to be in the past.")
    private Date birthDate;

    @OneToMany(mappedBy = "user") private List<Post> posts;

    protected User() {
    }

    public User(Integer id, String user, Date birthDate) {
        this.id = id;
        this.user = user;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override public String toString() {
        return "User{" + "id=" + id + ", user='" + user + '\'' + ", birthDate=" + birthDate + '}';
    }
}
