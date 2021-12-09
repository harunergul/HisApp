package com.erc.his.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erc.his.config.HibernateConfig;
import com.erc.his.entity.StaffDTO;

@Service
public class StaffService {
	
	@Autowired
	private HibernateConfig config;

	public StaffDTO save(StaffDTO dto) {
		if (dto.getStaffId() == null) {
			dto.setStaffId(config.generateID());
			dto.setStatus("1");
			config.save(dto);
		} else {
			config.update(dto);
		}
		return dto;
	}

	public List<StaffDTO> getAllStaffs() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT {t1.*} ");
		sql.append(" FROM AHSTAFF t1 ");
		sql.append(" WHERE t1.STATUS = '1' ");

		@SuppressWarnings("unchecked")
		NativeQuery<StaffDTO> query = config.getSession().createSQLQuery(sql.toString());
		query.addEntity("t1", StaffDTO.class);

		List<StaffDTO> results = query.list();
		List<StaffDTO> list = new ArrayList<>();
		for (StaffDTO item : results) {
			list.add(item);
		}
		return list;
	}
	
	
 
	 

 
 

}
