package com.erc.his.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erc.his.config.HibernateConfig;
import com.erc.his.entity.OrganizationDTO;

@Service
public class OrganizationService {

	@Autowired
	private HibernateConfig config;

	public OrganizationDTO save(OrganizationDTO dto) {
		if (dto.getOrganizationId() == null) {
			dto.setOrganizationId(config.generateID());
			dto.setStatus("1");
			config.save(dto);
		} else {
			config.update(dto);
		}
		return dto;
	}

	public List<OrganizationDTO> getAllOrganization() {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT {t1.*} ");
		sql.append(" FROM AHORGANIZATION t1 ");
		sql.append(" WHERE t1.STATUS = '1' ");

		@SuppressWarnings("unchecked")
		NativeQuery<OrganizationDTO> query = config.getSession().createSQLQuery(sql.toString());
		query.addEntity("t1", OrganizationDTO.class);

		List<OrganizationDTO> results = query.list();
		List<OrganizationDTO> list = new ArrayList<>();
		for (OrganizationDTO item : results) {
			list.add(item);
		}
		return list;
	}

	public OrganizationDTO getOrganizationByOrganizationCode(String organizationCode) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT {t1.*} ");
		sql.append(" FROM AHORGANIZATION t1 ");
		sql.append(" WHERE t1.STATUS = '1' ");
		sql.append(" AND t1.code =:organizationCode ");

		@SuppressWarnings("unchecked")
		NativeQuery<OrganizationDTO> query = config.getSession().createSQLQuery(sql.toString());
		query.addEntity("t1", OrganizationDTO.class);
		query.setParameter("organizationCode", organizationCode);

		List<OrganizationDTO> results = query.list();

		if (results.size() > 0) {
			return results.get(0);
		}
		return null;
	}

	public OrganizationDTO getOrganizationById(String organizationId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT {t1.*} ");
		sql.append(" FROM AHORGANIZATION t1 ");
		sql.append(" WHERE t1.STATUS = '1' ");
		sql.append(" AND t1.organizationId =:organizationId ");

		@SuppressWarnings("unchecked")
		NativeQuery<OrganizationDTO> query = config.getSession().createSQLQuery(sql.toString());
		query.addEntity("t1", OrganizationDTO.class);
		query.setParameter("organizationId", organizationId);

		List<OrganizationDTO> results = query.list();

		if (results.size() > 0) {
			return results.get(0);
		}
		return null;
	}

}
