package one.digitalinnovation.personapi.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "idade")
    private Long age;

    @Column(name = "estado")
    private String state;

//    @OneToMany
//    private List<PhoneEntity> phoneEntities;

}
