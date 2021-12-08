package com.erc.his.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erc.his.config.HibernateConfig;
import com.erc.his.entity.CodeValueDTO;
import com.erc.his.service.CodeValueService;

@RestController
@RequestMapping("/code-value")
public class CodeValueController {
	@Autowired
	private HibernateConfig config;

	@Autowired
	private CodeValueService codeValueService;

	@PostMapping("/save") // -> http://ip:port/code-value/save
	public ResponseEntity<CodeValueDTO> save(@RequestBody CodeValueDTO codeValueDTO) {

		if (codeValueDTO.getCodeValueId() == null) {
			codeValueDTO.setCodeValueId(config.generateID());
			codeValueDTO.setStatus("1");
			config.save(codeValueDTO);
		} else {
			config.update(codeValueDTO);
		}
		return new ResponseEntity<>(codeValueDTO, HttpStatus.OK);
	}

	@PostMapping("/delete") // -> http://ip:port/code-value/delete
	public ResponseEntity<CodeValueDTO> delete(@RequestBody CodeValueDTO codeValueDTO) {
		codeValueDTO.setStatus("0");
		config.update(codeValueDTO);
		return new ResponseEntity<>(codeValueDTO, HttpStatus.OK);
	}

	@GetMapping("/{id}") // -> http://ip:port/code-value/delete
	public ResponseEntity<CodeValueDTO> getData(@PathVariable Long id) {
		CodeValueDTO codeValueDTO = codeValueService.getCodeValueByCodeValueId(id); 
		return new ResponseEntity<>(codeValueDTO, HttpStatus.OK);
	}

	@GetMapping("/all/{codeValueId}")
	public ResponseEntity<List<CodeValueDTO>> getAllItems(@PathVariable Long codeValueId) {
		Session session = config.getSession();

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT {t1.*} ");
		sql.append(" FROM AHCODEVALUE t1 ");
		sql.append(" WHERE t1.STATUS = '1' ");
		sql.append(" AND t1.codeValueId =:codeValueId ");

		@SuppressWarnings("unchecked")
		NativeQuery<CodeValueDTO> query = session.createSQLQuery(sql.toString());
		query.addEntity("t1", CodeValueDTO.class);
		query.setParameter("codeValueId", codeValueId);

		List<CodeValueDTO> results = query.list();
		List<CodeValueDTO> list = new ArrayList<>();
		for (CodeValueDTO item : results) {
			list.add(item);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);

	}
	// code-type

	@GetMapping("/all/code-definition/{codeDefinitionId}")
	public ResponseEntity<List<CodeValueDTO>> getAllItemsByCodeDefinition(@PathVariable Long codeDefinitionId) {
		List<CodeValueDTO> list = codeValueService.getCodeValuesByCodeDefinitionId(codeDefinitionId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/code-definition/{codeDefinition}")
	public ResponseEntity<List<CodeValueDTO>> getAllItemsByCodeType(@PathVariable String codeDefinition) {
		List<CodeValueDTO> list = codeValueService.getCodeValuesByCodeDefinition(codeDefinition);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}
}
