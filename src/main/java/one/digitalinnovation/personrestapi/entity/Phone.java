package one.digitalinnovation.personrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personrestapi.enums.PhoneType;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY para ser incremental o Id
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // Campos obrigatorios
    private PhoneType type;

    @Column(nullable = false)
    private String number;

}
