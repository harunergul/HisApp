package com.erc.his.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erc.his.config.HibernateConfig;
import com.erc.his.entity.PatientDTO;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private HibernateConfig config;

	@PostMapping("/save") // -> http://ip:port/patient/save
	public ResponseEntity<PatientDTO> savePatient(@RequestBody PatientDTO patientDTO) {
		Session session = config.getSession();

		if (patientDTO.getPatientId() == null) {
			patientDTO.setPatientId(config.generateID());
			patientDTO.setStatus("1");
		}
		session.save(patientDTO);
		return new ResponseEntity<>(patientDTO, HttpStatus.OK);
	}

	@GetMapping("/all") // -> http://ip:port/patient/all
	public ResponseEntity<List<PatientDTO>> getAllPatients() {
		Session session = config.getSession();

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT {t1.*} ");
		sql.append(" FROM AHPATIENT t1 ");
		sql.append(" WHERE t1.STATUS = '1' ");

		@SuppressWarnings("unchecked")
		NativeQuery<Object[]> query = session.createSQLQuery(sql.toString());
		query.addEntity("t1", PatientDTO.class);

		List<Object[]> result = query.list();

		List<PatientDTO> patientList = new ArrayList<>();
		for (Object[] objects : result) {
			PatientDTO patientDTO = (PatientDTO) objects[0];
			patientList.add(patientDTO);

		}
		return new ResponseEntity<>(patientList, HttpStatus.OK);

	}

}
