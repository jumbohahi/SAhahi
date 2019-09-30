package com.okta.springbootvue.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
  
@Entity  
@Data  
@NoArgsConstructor  
public class Department {  
      
  @Id
  @SequenceGenerator(name = "department_seq", sequenceName = "department_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
  @Column(name = "department_id", unique = true, nullable = true)
  private Long departmentId;  


  private   @NonNull String departmentName; 
  
//   @OneToMany(fetch = FetchType.EAGER)
//   private Collection<Personnel> rent;  
 }