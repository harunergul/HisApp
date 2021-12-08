package com.erc.his.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erc.his.config.HibernateConfig;
import com.erc.his.entity.StaffTitleDTO;

@Service
public class StaffTitleService {

	@Autowired
	private HibernateConfig config;

	public StaffTitleDTO save(StaffTitleDTO dto) {
		if (dto.getStaffTitleId() == null) {
			dto.setStaffTitleId(config.generateID());
			dto.setStatus("1");
			config.save(dto);
		} else {
			config.update(dto);
		}
		return dto;
	}

	public List<StaffTitleDTO> getAllStaffTitles() {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT {t1.*} ");
		sql.append(" FROM AHSTAFFTITLE t1 ");
		sql.append(" WHERE t1.STATUS = '1' ");

		@SuppressWarnings("unchecked")
		NativeQuery<StaffTitleDTO> query = config.getSession().createSQLQuery(sql.toString());
		query.addEntity("t1", StaffTitleDTO.class);

		List<StaffTitleDTO> results = query.list();
		List<StaffTitleDTO> list = new ArrayList<>();
		for (StaffTitleDTO item : results) {
			list.add(item);
		}
		return list;
	}

}
