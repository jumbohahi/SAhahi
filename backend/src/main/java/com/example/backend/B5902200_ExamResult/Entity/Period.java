package com.example.backend.B5902200_ExamResult.Entity;      //กำลังบอกว่า package นี้ เป็นของ Entity
import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity                 //ทำให้ class Period เป็น Entity
@Data                   //เข้าใจ getter setter อัตโนมัติ เราจึงไม่สร้างก็ได้ 
@Table(name="period")   //บอกว่า Entity นี้ ทำหน้าที่ เก็บข้อมูล
@NoArgsConstructor
public class Period {   //บอกตำแหน่งปัจจุบัน
    @Id                                                                      //คือ annotation ที่ไว้สร้าง Primary Key
    @SequenceGenerator(name="period_seq",sequenceName="period_seq")          //
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="period_seq")//สร้าง period ให้อัตโนมัตติ
    @Column(name="periodId",unique = true, nullable = false)          

    private @NonNull Long id;                                        
    private @NonNull String periodName;          
    
    // @OneToMany(fetch = FetchType.EAGER)
    // // mappedBy  = "period"
    // private Collection<Document> period;


}