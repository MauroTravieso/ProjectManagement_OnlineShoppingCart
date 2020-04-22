package org.system.admin.model;

//import org.hibernaate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import org.system.role.model.Role;
import org.system.task.model.Task;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @Email
    @NotEmpty
    @Column(unique=true)
    private String email;
    @NotEmpty
    private String name;
    @Size(min=4)
    private String password;
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Task> tasks;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="USER_ROLES", joinColumns = {@JoinColumn(name="USER_EMAIL", referencedColumnName = "email")},
                                  inverseJoinColumns = {@JoinColumn(name="ROLE_NAME", referencedColumnName = "name")})
    private List<Role> roles;

    public User() {
    }

    public User(String email, String name, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
