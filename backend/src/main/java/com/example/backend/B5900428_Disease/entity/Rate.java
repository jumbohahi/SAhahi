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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Disease_Rate")
public class Rate {

    @Id
    @SequenceGenerator(name="disease_rate_seq",sequenceName="disease_rate_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="disease_rate_seq")  
    @Column(name = "RATE_ID", unique = true, nullable = true)
    private @NonNull Long rateid;
    private @NonNull String rate;
    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Disease> disease;
   
}