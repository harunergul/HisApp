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

import com.erc.his.entity.StaffTitleDTO;
import com.erc.his.service.StaffTitleService;

@RestController
@RequestMapping("/staff-title")
public class StaffTitleController {
	@Autowired
	private StaffTitleService service;

	@PostMapping("/save")
	public ResponseEntity<StaffTitleDTO> save(@RequestBody StaffTitleDTO dto) {
		dto = service.save(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PostMapping("/delete")
	public ResponseEntity<StaffTitleDTO> delete(@RequestBody StaffTitleDTO dto) {
		dto.setStatus("0");
		dto = service.save(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<StaffTitleDTO>> getAllStaffTitles() {
		List<StaffTitleDTO> list = service.getAllStaffTitles();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
