package com.erc.his.controller;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erc.his.config.HibernateConfig;
import com.erc.his.entity.AdmissionDTO;
import com.erc.his.entity.PatientDTO;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private HibernateConfig config;

	@PostMapping("/save") // -> http://ip:port/patient/save
	public ResponseEntity<PatientDTO> saveAdmission(@RequestBody PatientDTO patientDTO) {
		Session session = config.getSession();

		if (patientDTO.getPatientId() == null) {
			patientDTO.setPatientId(config.generateID());
			patientDTO.setStatus("1");
		}
		session.save(patientDTO);
		return new ResponseEntity<>(patientDTO, HttpStatus.OK);
	}

}
