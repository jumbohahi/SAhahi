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
@Table(name="Disease_Type")
public class Type {

    @Id
    @SequenceGenerator(name="disease_type_seq",sequenceName="disease_type_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="disease_type_seq")  
    @Column(name = "TYPE_ID", unique = true, nullable = true)
    private @NonNull Long typeid;
    private @NonNull String type;
    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Disease> disease;
   
}