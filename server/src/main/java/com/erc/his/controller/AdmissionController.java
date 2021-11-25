package com.erc.his.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.DateType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erc.his.config.HibernateConfig;
import com.erc.his.entity.AdmissionDTO;

@SuppressWarnings("deprecation")
@RestController
@RequestMapping("admission")
public class AdmissionController {
	
	@Autowired
	private HibernateConfig config;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping("/{admissionNo}")
	public ResponseEntity<AdmissionDTO> getAdmission(@PathVariable Long admissionNo) {

		Session session = config.getSession();
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT {t1.*}, t2.CODE AS orgCode, t2.NAME AS orgName, ");
		sql.append(" t3.NAME AS docName, t3.SURNAME AS docSurname, t3.REGISTRY AS docRegistry, ");
		sql.append(" t4.PATIENTNO AS patNo, t4.NAME AS patientName, t4.SURNAME AS patientSurname, t4.BIRTHDAY AS patientBirthday, t4.GENDER AS patientGender, t4.TC_NO AS patientTC ");
		sql.append(" FROM CKADMISSION t1 ");
		sql.append(" LEFT JOIN CKORGANIZATION t2 ON	t1.ORGANIZATION_ID = t2.ORG_ID ");
		sql.append(" LEFT JOIN CKSTAFF t3 ON t1.STAFF_ID = t3.STAFF_ID ");
		sql.append(" LEFT JOIN CKPATIENT t4 ON t1.PATIENT_ID = t4.PAT_ID ");
		sql.append(" WHERE t1.STATUS = '1' AND t1.ADMISSION_NO = ");
		sql.append(admissionNo);
		
		@SuppressWarnings("unchecked")
		NativeQuery<Object[]> query = session.createSQLQuery(sql.toString());
		query.addEntity("t1", AdmissionDTO.class);
		query.addScalar("orgCode", new StringType());
		query.addScalar("orgName", new StringType());
		query.addScalar("docName", new StringType());
		query.addScalar("docSurname", new StringType());
		query.addScalar("docRegistry", new LongType());
		query.addScalar("patNo", new LongType());
		query.addScalar("patientName", new StringType());
		query.addScalar("patientSurname", new StringType());
		query.addScalar("patientBirthday", new DateType());
		query.addScalar("patientGender", new StringType());
		query.addScalar("patientTC", new LongType());
		List<Object[]> result = query.list();

		AdmissionDTO admissionDTO =null;
		for (Object[] objects : result) {
			  admissionDTO = (AdmissionDTO) objects[0];
			
			String organizationCode = (String) objects[1];
			String organizationName = (String) objects[2];
			String doctorName = (String) objects[3];
			String doctorSurname = (String) objects[4];
			Long docRegistry = (Long) objects[5];
			Long patientNo = (Long) objects[6];
			String patientName = (String) objects[7];
			String patientSurname = (String) objects[8];
			Date patientBirthday = (Date) objects[9];
			String patientGender = (String) objects[10];
			Long patientTC = (Long) objects[11];
			
			admissionDTO.setScalarOrganizationCode(organizationCode);
			admissionDTO.setScalarOrganizationName(organizationName);
			admissionDTO.setScalarDoctorName(doctorName);
			admissionDTO.setScalarDoctorSurname(doctorSurname);
			admissionDTO.setScalarDoctorRegistry(docRegistry);
			admissionDTO.setPatientNo(patientNo);
			admissionDTO.setScalarPatientName(patientName);
			admissionDTO.setScalarPatientSurname(patientSurname);
			admissionDTO.setScalarPatientBirthday(patientBirthday);
			admissionDTO.setScalarPatientGender(patientGender);
			admissionDTO.setScalarPatientTC(patientTC);
			
		}
		return new ResponseEntity<>(admissionDTO, HttpStatus.OK);
	}
	
	@GetMapping("/closeAdmissions")
	public ResponseEntity<List<AdmissionDTO>> getAdmission() {

		Session session = config.getSession();
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT {t1.*}, t2.NAME AS orgName, ");
		sql.append(" t3.NAME AS docName, t3.SURNAME AS docSurname, ");
		sql.append(" t4.PATIENTNO AS patNo ");
		sql.append(" FROM CKADMISSION t1 ");
		sql.append(" LEFT JOIN CKORGANIZATION t2 ON	t1.ORGANIZATION_ID = t2.ORG_ID ");
		sql.append(" LEFT JOIN CKSTAFF t3 ON	t1.STAFF_ID = t3.STAFF_ID ");
		sql.append(" LEFT JOIN CKPATIENT t4 ON t1.PATIENT_ID = t4.PAT_ID ");
		sql.append(" WHERE t1.STATUS = '1' AND t1.CLOSE_STATUS = 'CLOSE'");
		
		@SuppressWarnings("unchecked")
		NativeQuery<Object[]> query = session.createSQLQuery(sql.toString());
		query.addEntity("t1", AdmissionDTO.class);
		query.addScalar("orgName", new StringType());
		query.addScalar("docName", new StringType());
		query.addScalar("docSurname", new StringType());
		query.addScalar("patNo", new LongType());
		List<Object[]> result = query.list();

		List<AdmissionDTO> admission = new ArrayList<>();
		for (Object[] objects : result) {
			AdmissionDTO  admissionDTO = (AdmissionDTO) objects[0];
			
			String organizationName = (String) objects[1];
			String doctorName = (String) objects[2];
			String doctorSurname = (String) objects[3];
			Long patientNo = (Long) objects[4];
			
			admissionDTO.setScalarOrganizationName(organizationName);
			admissionDTO.setScalarDoctorName(doctorName);
			admissionDTO.setScalarDoctorSurname(doctorSurname);
			admissionDTO.setPatientNo(patientNo);
			
			admission.add(admissionDTO);
			
		}
		return new ResponseEntity<>(admission, HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<AdmissionDTO> saveAdmission(@RequestBody AdmissionDTO admissionDTO) throws Exception{
		Session session = config.getSession();
		session.clear();
		admissionDTO.setAdmissionId(config.generateID());
		admissionDTO.setAdmissionNo(config.generateID());
		admissionDTO.setStatus("1");
		admissionDTO.setCloseStatus("OPEN");
		session.beginTransaction();
		session.save(admissionDTO);
		session.getTransaction().commit();
		
		return new ResponseEntity<>(admissionDTO, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<AdmissionDTO> updateAdmission(@RequestBody AdmissionDTO admissionDTO) throws Exception{
		Session session = config.getSession();
		session.clear();
		session.beginTransaction();
		admissionDTO.setCloseStatus("CLOSE");
		session.update(admissionDTO);
		session.getTransaction().commit();
		return new ResponseEntity<>(admissionDTO, HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<AdmissionDTO> deleteAdmission(@RequestBody AdmissionDTO admissionDTO) throws Exception{
		Session session = config.getSession();
		session.clear();
		session.beginTransaction();
		admissionDTO.setStatus("0");
		session.update(admissionDTO);
		session.getTransaction().commit();
		return new ResponseEntity<>(admissionDTO, HttpStatus.OK);
	}
	
 
}
