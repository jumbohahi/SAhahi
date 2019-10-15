package com.example.backend.B5923403_Personnel.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@Table(name="POSITION")
@Getter @Setter
public class Position {
    @Id
    @SequenceGenerator(name="position_seq",sequenceName="position_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="position_seq")
    @Column(name="POSITION_ID",unique = true, nullable = true)
    private @NotNull Long positionId;
    private @NotNull String positionName;

    // @OneToMany(fetch = FetchType.EAGER)
    // private Collection<Personnel> rent;
}

