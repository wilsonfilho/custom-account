package io.pismo.challenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;


@Entity()
@Getter
@Setter
@NoArgsConstructor
public class OperationType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @NotNull
    @Column(name = "description")
    private String description;

}





