package com.crud.crudoperation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok annotation to create all the getters, setters, equals, hashcode, and
      // toString methods for the entity class
@AllArgsConstructor // Lombok annotation to create a constructor with all the fields of the entity
                    // class
@NoArgsConstructor // Lombok annotation to create a constructor with no arguments
@Entity
@Table(name = "studnets")
public class Students {

    @Id
    private int student_id;
    private String student_name;
    private int student_class;
    private String student_section;
}
