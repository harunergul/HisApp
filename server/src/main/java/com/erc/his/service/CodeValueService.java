package com.erc.his.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erc.his.config.HibernateConfig;
import com.erc.his.entity.CodeDefinitionDTO;
import com.erc.his.entity.CodeValueDTO;

@Service
public class CodeValueService {

	@Autowired
	private HibernateConfig config;

	@Autowired
	private CodeDefinitionService codeDefinitionService;


	public List<CodeValueDTO> getCodeValuesByCodeDefinition(String codeDefinition) {
		CodeDefinitionDTO codeDefinitionDTO = codeDefinitionService
				.getCodeDefinitionDTOByCodeDefinition(codeDefinition);

		if (codeDefinitionDTO == null)
			return null;
		return getCodeValuesByCodeDefinitionId(codeDefinitionDTO.getCodeDefinitionId());

	}

	public List<CodeValueDTO> getCodeValuesByCodeDefinitionId(Long codeDefinitionId) {
		Session session = config.getSession();

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT {t1.*} ");
		sql.append(" FROM AHCODEVALUE t1 ");
		sql.append(" WHERE t1.STATUS = '1' ");
		sql.append(" AND t1.codeDefinitionId =:codeDefinitionId ");

		@SuppressWarnings("unchecked")
		NativeQuery<CodeValueDTO> query = session.createSQLQuery(sql.toString());
		query.addEntity("t1", CodeValueDTO.class);
		query.setParameter("codeDefinitionId", codeDefinitionId);

		List<CodeValueDTO> results = query.list();
		List<CodeValueDTO> list = new ArrayList<>();
		for (CodeValueDTO item : results) {
			list.add(item);
		}
		return list;

	}

	public CodeValueDTO getCodeValueByCodeValueId(Long codeValueId) {
		Session session = config.getSession();

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT {t1.*} ");
		sql.append(" FROM AHCODEVALUE t1 ");
		sql.append(" WHERE t1.STATUS = '1' AND t1.active='1' ");
		sql.append(" AND t1.codeValueId =:codeValueId ");

		@SuppressWarnings("unchecked")
		NativeQuery<CodeValueDTO> query = session.createSQLQuery(sql.toString());
		query.addEntity("t1", CodeValueDTO.class);
		query.setParameter("codeValueId", codeValueId);

		List<CodeValueDTO> results = query.list();
		if (results != null && results.size() > 0) {
			return results.get(0);
		} else {
			return null;
		}
	}

}
