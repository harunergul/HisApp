package com.erc.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erc.his.entity.StaffDTO;
import com.erc.his.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	private StaffService service;

	@PostMapping("/save")
	public ResponseEntity<StaffDTO> save(@RequestBody StaffDTO dto) {
		dto = service.save(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PostMapping("/delete")
	public ResponseEntity<StaffDTO> delete(@RequestBody StaffDTO dto) {
		dto.setStatus("0");
		dto = service.save(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<StaffDTO>> getAll() {
		List<StaffDTO> list = service.getAllStaffs();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
