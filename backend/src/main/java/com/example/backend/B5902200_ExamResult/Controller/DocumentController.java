package com.example.backend.B5902200_ExamResult.Controller;                      //กำลังบอกว่า package นี้ เป็นของ Controller
import com.example.backend.B5902200_ExamResult.Repository.*;
import com.example.backend.B5902200_ExamResult.Entity.*;
import com.example.backend.B5923403_Personnel.entity.Personnel;
import com.example.backend.B5923403_Personnel.repository.PersonnelRepository;
import com.example.backend.B5923144_infec.entity.Patient;
import com.example.backend.B5923144_infec.repository.PatientRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
@RestController                                     //บังคับให้ class นี้เป็น Controller
@CrossOrigin(origins = "http://localhost:8080")     //ทำให้ spingboot , vue ส่งข้อมูหากันได้
class DocumentController{                           //บอกตำแหน่งปัจจุบัน 
    @Autowired                                      //สร้างผู้ช่วย ที่คอยสั่ง Repo ให้ทำงานอัตโนมัติ
    private DocumentRepository documentRepository;  //สร้าง Obj ชื่อ documentRepo.. ชนิด DocumentRepo.. เพื่อใช้งาน Entity Document
    @Autowired                                      //สร้างผู้ช่วย ที่คอยสั่ง Repo ให้ทำงานอัตโนมัติ
    private PatientRepository patientRepository;    //สร้าง Obj ชื่อ patientRepo.. ชนิด PatientRepo.. เพื่อใช้งาน Entity Patient
    @Autowired                                      //สร้างผู้ช่วย ที่คอยสั่ง Repo ให้ทำงานอัตโนมัติ
    private PersonnelRepository personnelRepository;  //สร้าง Obj ชื่อ personelRepo.. ชนิด PersonelRepo.. เพื่อใช้งาน Entity Personel
    @Autowired                                      //สร้างผู้ช่วย ที่คอยสั่ง Repo ให้ทำงานอัตโนมัติ
    private PeriodRepository periodRepository;      //สร้าง Obj ชื่อ periodRepo.. ชนิด PeriodRepo.. เพื่อใช้งาน Entity Period
    
                                                    //เริ่มสร้าง Object ของ Entity หลัก

    DocumentController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @GetMapping("/document")                                                       // get ข้อมูลตาม พาท ที่กำหนดจากหน้าเว็บ 9000/documents
    public Collection<Document> Documents() {                                    // ดึงข้อมูลจากใน Entity <Document> โดยทำเป็น collection 
        return documentRepository.findAll().stream().collect(Collectors.toList());  // ส่งค่าทั้งหมดใน document return ไปแสดงที่หน้า 9000/document โดยส่งทั้งหมดออกไปเป็น list
    }

    @PostMapping("/document/{patientID}/{personelID}/{examresultName}/{periodID}")
    public Document newDocument(Document newDocument,
    
    @PathVariable long patientID,
    @PathVariable long personelID,
    @PathVariable String examresultName,
    @PathVariable long periodID ) {
        System.out.println(">>>>>>>>>>>>>>>>>" + examresultName);

        Patient patient = patientRepository.findById(patientID);
        Personnel personel = personnelRepository.findById(personelID);
        Period period = periodRepository.findById(periodID);



        newDocument.setPatient(patient);
        newDocument.setPersonnel(personel);
        newDocument.setPeriod(period);

        
                                                       
        return documentRepository.save(newDocument);
    }
}