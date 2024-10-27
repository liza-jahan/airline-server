package com.lina.airline.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
@Entity
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;
    private String name;


    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> userEntity = new HashSet<>();

}
