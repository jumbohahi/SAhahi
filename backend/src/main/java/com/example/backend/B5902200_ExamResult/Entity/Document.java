package com.example.backend.B5902200_ExamResult.Entity; //กำลังบอกว่า package นี้ เป็นของ Entity

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.backend.B5923144_infec.entity.Patient;
import com.example.backend.B5923403_Personnel.entity.Personnel;
import com.example.backend.B5902200_ExamResult.Entity.Period;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity                 //ทำให้ class Document เป็น Entity
@Data                   //กำหนดให้เก็บข้อมูล และช่วยในการสร้าง get , set
@Table                  //บอกว่า Entity นี้ ทำหน้าที่ เก็บข้อมูล
@Getter                 //เรียกใช้ Getter เอาไว้จำกัดการเข้าถึง เพื่อ get ค่าให้กับแต่ละ attribute
@Setter                 //เรียกใช้ Setter เอาไว้จำกัดการเข้าถึง เพื่อ set ค่าให้กับแต่ละ attribute
@NoArgsConstructor      //
public class Document { //บอกตำแหน่งปัจจุบัน
    @Id                                                                         //คือ annotation ที่ไว้สร้าง Primary Key
    @SequenceGenerator(name="document_seq",sequenceName="document_seq")         //
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="document_seq") //
    @Column(name="documentId",unique = true, nullable = false)                  //ชื่อคอลัม documentId , ไม่ซ้ำ , ไม่ว่าง 
    private Long id;    
                                                    //จำกัดการเข้าถึง documentId
    @Column(name="examresultName")
    private @NonNull String examresultName;                     //จำกัดการเข้าถึง examresultName และ ห้าม examresultName ว่าง


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Patient.class)
    @JoinColumn(name = "patientID", insertable = true)
    private Patient patient;
         
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Personnel.class) 
    @JoinColumn(name = "personelID", insertable = true)
    private @NonNull Personnel personnel;  
   
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Period.class)   
    @JoinColumn(name = "periodID", insertable = true)
    private @NonNull Period period;   
    
}