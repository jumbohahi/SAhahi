package com.example.backend.B5900428_Disease.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.example.backend.B5923403_Personnel.entity.Personnel;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Disease")
public class Disease {

    @Id
    @SequenceGenerator(name="disease_seq",sequenceName="disease_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="disease_seq")  
    @Column(name = "DISEASE_ID", unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String diseaseName;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Personnel.class)
    @JoinColumn(name = "PERSONAL_ID", insertable = true)
    private @NonNull Personnel personnel;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Rate.class)
    @JoinColumn(name = "RATE_ID", insertable = true)
    private @NonNull Rate rate;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Type.class)
    @JoinColumn(name = "TYPE_ID", insertable = true)
    private  @NonNull Type type;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Symptom.class)
    @JoinColumn(name = "SYMPTOM_ID", insertable = true)
    private @NonNull Symptom symptom;



}