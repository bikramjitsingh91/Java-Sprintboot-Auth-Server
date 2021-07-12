package com.authorization.sequirty.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private String role;
}
