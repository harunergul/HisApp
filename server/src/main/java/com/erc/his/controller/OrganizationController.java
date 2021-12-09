package com.erc.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erc.his.entity.OrganizationDTO;
import com.erc.his.service.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
	
	@Autowired
	private OrganizationService service;
	

	@PostMapping("/save")  
	public ResponseEntity<OrganizationDTO> save(@RequestBody OrganizationDTO dto) {
		dto = service.save(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping("/delete")  
	public ResponseEntity<OrganizationDTO> delete(@RequestBody OrganizationDTO dto) {
		dto.setStatus("0");
		dto = service.save(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/all") 
	public ResponseEntity<List<OrganizationDTO>> getAllOrganization() {
		List<OrganizationDTO> list = service.getAllOrganization();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/code/{organizationCode}") 
	public ResponseEntity<OrganizationDTO> getAllOrganization(@PathVariable String organizationCode) {
		OrganizationDTO dto = service.getOrganizationByOrganizationCode(organizationCode);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
