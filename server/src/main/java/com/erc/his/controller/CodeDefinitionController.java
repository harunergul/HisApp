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
import com.erc.his.entity.CodeDefinitionDTO;

@RestController
@RequestMapping("/code-definition")
public class CodeDefinitionController { 

	@Autowired
	private HibernateConfig config;

	@PostMapping("/save") // -> http://ip:port/code-definition/save
	public ResponseEntity<CodeDefinitionDTO> save(@RequestBody CodeDefinitionDTO codeDefinitionDTO) {

		if (codeDefinitionDTO.getCodeDefinitionId() == null) {
			codeDefinitionDTO.setCodeDefinitionId(config.generateID());
			codeDefinitionDTO.setStatus("1");
			config.save(codeDefinitionDTO);
		} else {
			config.update(codeDefinitionDTO);
		}
		return new ResponseEntity<>(codeDefinitionDTO, HttpStatus.OK);
	}

	@PostMapping("/delete") // -> http://ip:port/code-definition/delete
	public ResponseEntity<CodeDefinitionDTO> delete(@RequestBody CodeDefinitionDTO codeDefinitionDTO) {
		codeDefinitionDTO.setStatus("0");
		config.update(codeDefinitionDTO);
		return new ResponseEntity<>(codeDefinitionDTO, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<CodeDefinitionDTO>> getAllItems() {
		Session session = config.getSession();

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT {t1.*} ");
		sql.append(" FROM AHCODEDEFINITION t1 ");
		sql.append(" WHERE t1.STATUS = '1' ");

		@SuppressWarnings("unchecked")
		NativeQuery<CodeDefinitionDTO> query = session.createSQLQuery(sql.toString());
		query.addEntity("t1", CodeDefinitionDTO.class);

		List<CodeDefinitionDTO> results = query.list();
		List<CodeDefinitionDTO> list = new ArrayList<>();
		for (CodeDefinitionDTO patient : results) {
			list.add(patient);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);

	}
	 
	
}
