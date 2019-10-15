package com.example.backend;

import com.example.backend.B5923403_Personnel.entity.Department;
import com.example.backend.B5923403_Personnel.entity.Position;
import com.example.backend.B5923403_Personnel.entity.*;
import com.example.backend.B5923144_infec.entity.*;
import com.example.backend.B5923144_infec.repository.ProvinceRepository;
import com.example.backend.B5900428_Disease.entity.Disease;
// import com.example.backend.B5806171_stat.Entity.*;
// import com.example.backend.B5806171_stat.Repository.DiseasedataRepository;
import com.example.backend.B5900428_Disease.entity.Rate;
import com.example.backend.B5900428_Disease.entity.Symptom;
import com.example.backend.B5900428_Disease.entity.Type;
import com.example.backend.B5900428_Disease.repository.DiseaseRepository;
import com.example.backend.B5900428_Disease.repository.RateRepository;
import com.example.backend.B5900428_Disease.repository.SymptomRepository;
import com.example.backend.B5900428_Disease.repository.TypeRepository;
import com.example.backend.B5902200_ExamResult.Entity.Period;
import com.example.backend.B5902200_ExamResult.Repository.PeriodRepository;
// import com.example.backend.B5806171_stat.Entity.Disease;
// import com.example.backend.B5806171_stat.Entity.Province;
import com.example.backend.B5923403_Personnel.repository.DepartmentRepository;
import com.example.backend.B5923403_Personnel.repository.PositionRepository;
import com.example.backend.B5923403_Personnel.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.backend.B5923144_infec.repository.*;
//import com.example.backend.B5923144_infec.entity.*;
// import com.example.backend.B5902200_ExamResult.Entity.*;
// import com.example.backend.B5902200_ExamResult.Entity.Patient;
// import com.example.backend.B5902200_ExamResult.Repository.*;


import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(PrefixRepository prefixRepository, PositionRepository positionRepository,
			DepartmentRepository departmentRepository, DiseaseRepository diseaseRepository,
			ProvinceRepository provinceRepository, RateRepository rateRepository,SymptomRepository symptomRepository,TypeRepository typeRepository
			,PeriodRepository periodRepository, PersonnelRepository personnelRepository ) {
				//, PatientRepository patientRepository
		return args -> {
			Stream.of("นาย", "นางสาว", "นาง").forEach(prefixName -> {
				Prefix prefix = new Prefix();
				prefix.setPrefixName(prefixName);
				prefixRepository.save(prefix);
			});

			Stream.of("หมอ", "พยาบาล").forEach(positionName -> {
				Position position = new Position();
				position.setPositionName(positionName);
				positionRepository.save(position);
			});

			Stream.of("แผนกผู้ป่วยใน", "แผนกผู้ป่วยนอก").forEach(departmentName -> {
				Department department = new Department();
				department.setDepartmentName(departmentName);
				departmentRepository.save(department);
			});
			Stream.of("เสี่ยงต่อการระบาด", "สามารถควบคุมได้").forEach(rate -> {
				Rate r = new Rate();
				r.setRate(rate);
				
				rateRepository.save(r);
			  });
	  
			  Stream.of("โรคติดต่อร้ายแรง", "โรคติดต่อไม่ร้ายแรง").forEach(symptom -> {
				Symptom s = new Symptom();
				s.setSymptom(symptom);
				symptomRepository.save(s);
			  });
			  
			  Stream.of("โรคติดต่ออันตราย", "โรคติดต่อ" , "โรคติดต่อที่ต้องแจ้งความ").forEach(type -> {
				  Type t = new Type();
				  t.setType(type);
				  typeRepository.save(t);
				});
				Stream.of("โรคตาแดง","อหิวาตกโรค","โรคไข้หวัดใหญ่","กาฬโรค").forEach(dis -> {
					Disease disease = new Disease();
					disease.setDiseaseName(dis);
					diseaseRepository.save(disease);
				});
	  
			//   Stream.of("พันธุกรรม", "เลือด", "เข็มฉีดยา","น้ำมูก", "ไม่ทราบแน่ชัด").forEach(period -> {
			// 	Diseasedata p = new Diseasedata();
			// 	p.setDiseasedataName(period);
			// 	diseasedataRepository.save(p);
			//   });
	  
			  Stream.of("กรุงเทพมหานคร","กระบี่","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา","ชลบุรี","ชัยนาท"," ชัยภูมิ"
			  ,"ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา","นครศรีธรรมราช","นครสวรรค์","นนทบุรี","นราธิวาส","น่าน",
			  "บึงกาฬ"," บุรีรัมย์","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี","พระนครศรีอยุธยา","พังงา","พัทลุง","พิจิตร","พิษณุโลก"," เพชรบุรี"," เพชรบูรณ์","แพร่","พะเยา",
			 "ภูเก็ต"," มหาสารคาม","มุกดาหาร"," แม่ฮ่องสอน"," ยะลา"," ยโสธร"," ร้อยเอ็ด"," ระนอง"," ระยอง"," ราชบุรี"," ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา"
			 ,"สตูล","สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี"," สุราษฎร์ธานี"," สุรินทร์"," หนองคาย"," หนองบัวลำภู","อ่างทอง"
			 ,"อุดรธานี","อุทัยธานี","อุตรดิตถ์","อุบลราชธานี","อำนาจเจริญ").forEach(patient -> {
				Province p = new Province();
				p.setPro(patient);
				provinceRepository.save(p);
			  });

			//  Stream.of("พยาบาล ปุยนุ่น", "พยาบาล โดมฤดี" ,
            //       "พยาบาล รัตนโกสุมภ์", "พยาบาล เอ็นพี" , 
            //       "พยาบาล ปุ๊ปปั๊ป", "พยาบาล คณต" , 
            //       "พยาบาล วังคะฮาด", "พยาบาล พีเอ็น ").forEach(personnelName -> {
            //         Personnel personnel = new Personnel(); 
            //         personnel.setPersonnelName(personnelName); 
            //         personnelRepository.save(personnel); 
			// 		});
		

			// Stream.of("นาย สมชาย", "นาง สมหญิง", 
			// 		"นางสาว สมใจ", "เด็กชาย สมทรง", 
			// 		"เด็กหญิง สมน้ำหน้า", "Mr.Somsaksri", 
			// 		"Mrs.Somwang" , "Miss Somsri").forEach(patientName -> {
			// 		Patient patient = new Patient();
			// 		patient.setName(patientName);
			// 		patientRepository.save(patient);
			// });

			Stream.of("00.01 - 12.00", "12.01 - 00.00", 
						"มากกว่า 1 วัน", "มากกว่า 3 วัน", 
						"มากกว่า 5 วัน", "มากกว่า 7 วัน", 
						"มากกว่า 1 เดือน", "ไม่ทราบแน่ชัด").forEach(periodName -> {
				Period period = new Period();
				period.setPeriodName(periodName);
				periodRepository.save(period);
				});

			// Stream.of("นาย สมชาย", "นาง สมหญิง", 
			// 			"นางสาว สมใจ", "เด็กชาย สมทรง", 
			// 			"เด็กหญิง สมน้ำหน้า", "Mr.Somsaksri", 
			// 			"Mrs.Somwang" , "Miss Somsri").forEach(patientName -> {
			// 	Patient patient = new Patient();
			// 	patient.setPatientName(patientName);
			// 	patientRepository.save(patient);
			// 	});

			  
		};
	}

}
