package com.erc.his.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.type.StringType;
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
		sql.append(" SELECT {t1.*}, t2.name as organizationName, t3.name as title ");
		sql.append(" FROM AHSTAFF t1  ");
		sql.append(" LEFT JOIN AHORGANIZATION t2 ON  t1.ORGANIZATIONID = t2.ORGANIZATIONID ");
		sql.append(" LEFT JOIN AHSTAFFTITLE t3 ON  t3.STAFFTITLEID  = t1.STAFFTITLEID  ");
		sql.append(" WHERE t1.STATUS = '1' ");

		@SuppressWarnings("unchecked")
		NativeQuery<Object[]> query = config.getSession().createSQLQuery(sql.toString());
		query.addEntity("t1", StaffDTO.class);
		query.addScalar("organizationName", new StringType());
		query.addScalar("title", new StringType());

		List<Object[]> results =(List<Object[]>) query.list();
		List<StaffDTO> list = new ArrayList<>();
		for (Object[] item : results) {
			StaffDTO staffDTO =(StaffDTO)item[0];

			if (item[1] != null) {
				staffDTO.setScalarOrganizationName((String) item[1]);
			}
			if (item[2] != null) {
				staffDTO.setScalarStaffTitle((String) item[2]);
			}

			list.add(staffDTO);
		}
		return list;
	}

}
