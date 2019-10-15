package com.example.backend.B5923403_Personnel.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@Table(name="PREFIX")
@Getter @Setter
public class Prefix {
    @Id
    @SequenceGenerator(name="prefix_seq",sequenceName="prefix_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prefix_seq")
    @Column(name="PREFIX_ID",unique = true, nullable = true)
    private @NotNull Long prefixId;
    private @NotNull String prefixName;

    // @OneToMany(fetch = FetchType.EAGER)
    // private Collection<Personnel> rent;
}
