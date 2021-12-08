package com.erc.his.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erc.his.config.HibernateConfig;
import com.erc.his.entity.CodeDefinitionDTO;

@Service
public class CodeDefinitionService {

	@Autowired
	private HibernateConfig config;
	
	public CodeDefinitionDTO getCodeDefinitionDTOByCodeDefinition(String code) {
		Session session = config.getSession();

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT {t1.*} ");
		sql.append(" FROM AHCODEDEFINITION t1 ");
		sql.append(" WHERE t1.STATUS = '1' ");
		sql.append(" AND t1.codeType=:code ");

		@SuppressWarnings("unchecked")
		NativeQuery<CodeDefinitionDTO> query = session.createSQLQuery(sql.toString());
		query.addEntity("t1", CodeDefinitionDTO.class);
		query.setParameter("code", code);
		List<CodeDefinitionDTO> results = query.list();

		if (results != null && results.size() > 0) {
			return results.get(0);
		}

		return null;

	}
}
