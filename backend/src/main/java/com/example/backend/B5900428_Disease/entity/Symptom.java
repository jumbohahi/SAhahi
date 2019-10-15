package com.example.backend.B5900428_Disease.entity;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Disease_Symptom")
public class Symptom {

    @Id
    @SequenceGenerator(name="disease_symptom_seq",sequenceName="disease_symptom_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="disease_symptom_seq")  
    @Column(name = "SYMPTOM_ID", unique = true, nullable = true)
    private @NonNull Long symptomid;
    private @NonNull String symptom;
    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Disease> disease;
   
}