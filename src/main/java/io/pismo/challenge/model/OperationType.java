package io.pismo.challenge.model;

import io.pismo.challenge.enums.OperationEntry;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import static io.pismo.challenge.enums.OperationEntry.CREDIT;
import static jakarta.persistence.EnumType.STRING;
import static java.util.Objects.isNull;


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

    @Enumerated(STRING)
    @Column(name ="entry")
    private OperationEntry entry;

    public boolean isCredit() {
        if (isNull(entry)) {
            return false;
        }
        return entry == CREDIT;
    }

}





