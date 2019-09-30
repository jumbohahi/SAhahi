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
public class Position {  
      
  @Id
  @SequenceGenerator(name = "position_seq", sequenceName = "position_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_seq")
  @Column(name = "position_id", unique = true, nullable = true)
  private long positionId;  

  
  private @NonNull String positionName; 
  
  // @OneToMany(fetch = FetchType.EAGER)
  // private Collection<Personnel> rent;  
}

