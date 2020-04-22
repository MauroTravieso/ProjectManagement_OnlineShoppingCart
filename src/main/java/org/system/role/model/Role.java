package org.system.role.model;

import lombok.Data;
import org.system.admin.model.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class Role {

    @Id
    private String name;
    @ManyToMany(mappedBy="roles")
    private List<User> users;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }


}
