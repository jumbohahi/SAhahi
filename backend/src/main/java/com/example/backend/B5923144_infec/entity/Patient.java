package com.example.backend.B5923144_infec.entity;

import lombok.*;
import javax.persistence.*;

import com.example.backend.B5923403_Personnel.entity.Personnel;
import com.example.backend.B5900428_Disease.entity.Disease;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Patient")
public class Patient {

    @Id
    @SequenceGenerator(name="Patient_seq",sequenceName="Patient_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Patient_seq")
    @Column(name = "Patient_ID")

    private @NonNull Long paid;
    private @NonNull String name;
    private int age;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "Province_ID")
    private Province province;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Personnel.class)
    @JoinColumn(name = "Personnel_ID")
    private Personnel personnel;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Disease.class)
    @JoinColumn(name = "Disease_ID")
    private Disease disease;

}
