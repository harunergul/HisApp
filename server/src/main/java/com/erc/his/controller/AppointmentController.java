package com.erc.his.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erc.his.entity.AppointmentDTO;
import com.erc.his.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	private AppointmentService service;

	@PostMapping("/save")
	public ResponseEntity<AppointmentDTO> save(@RequestBody AppointmentDTO dto) {
		dto = service.save(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping
	public List<AppointmentDTO> getAppointmentsByOrganizationAndDate(
			@RequestParam(name = "organizationId") String organizationId,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		System.out.println(organizationId);
		System.out.println(date);
		return null;
	}

}
