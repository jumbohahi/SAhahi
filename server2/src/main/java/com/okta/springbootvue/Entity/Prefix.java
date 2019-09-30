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
public class Prefix {  
      
  @Id
  @SequenceGenerator(name = "prefix_seq", sequenceName = "prefix_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prefix_seq")
  @Column(name = "prefix_id", unique = true, nullable = true)
  private Long prefixId;  

 
  private  @NonNull String prefixName;

  // @OneToMany(fetch = FetchType.EAGER)
  // private Collection<Personnel> rent;  
}