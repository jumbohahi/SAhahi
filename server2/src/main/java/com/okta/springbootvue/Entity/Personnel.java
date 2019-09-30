package com.okta.springbootvue.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Personnel {

  @Id
  @SequenceGenerator(name = "personnel_seq", sequenceName = "personnel_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personnel_seq")
  @Column(name = "personnel_id", unique = true, nullable = true)
  private Long personnelId;

  @NonNull
  private String personnelName;

  @NonNull
  private String personnelRole;

  @ManyToOne()
  private @NotNull Position position;

  @ManyToOne()
  private @NotNull Department department;

  // @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
  // @JoinColumn(name="Role") private @NotNull Role Role;

  @ManyToOne()
  private @NotNull Prefix prefix;

}