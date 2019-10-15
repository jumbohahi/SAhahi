package com.example.backend.B5923403_Personnel.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@Table(name="DEPARTMENT")
@Getter @Setter
public class Department {
    @Id
    @SequenceGenerator(name="department_seq",sequenceName="department_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="department_seq")
    @Column(name="DEPARTMENT_ID",unique = true, nullable = true)
    private @NotNull Long departmentId;
    private @NotNull String departmentName;

    // @OneToMany(fetch = FetchType.EAGER)
    // private Collection<Personnel> rent;
}
