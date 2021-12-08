package com.erc.his.client.component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import com.erc.his.ClientApp;
import com.erc.his.entity.CodeValueDTO;

public class CodeValueCache {
	public Long codeValueId;
	public LocalDateTime requestDate;
	public CodeValueDTO codeValueDTO;

	private static Map<Long, CodeValueCache> cachedCodeValue = new HashMap<Long, CodeValueCache>();

	public static CodeValueDTO getCachedCodeValue(Long codeValueId) {
		if (cachedCodeValue.containsKey(codeValueId)) {
			CodeValueCache codeValueCache = cachedCodeValue.get(codeValueId);
			LocalDateTime tempDateTime = LocalDateTime.from(codeValueCache.requestDate);
			long minutes = tempDateTime.until(LocalDateTime.now(), ChronoUnit.MINUTES);
			if (minutes > 3) {
				codeValueCache.requestDate = LocalDateTime.now();
				codeValueCache.codeValueId = codeValueId;
				try {
					CodeValueDTO codeValueDTO = ClientApp.getCodeValueByCodeValueId(codeValueId);
					codeValueCache.codeValueDTO = codeValueDTO;
				} catch (Exception e) {
					e.printStackTrace();
				}
				cachedCodeValue.put(codeValueId, codeValueCache);
			}
			return codeValueCache.codeValueDTO;

		} else {
			CodeValueDTO codeValueDTO;
			CodeValueCache cache = new CodeValueCache();
			cache.codeValueId = codeValueId;
			cache.requestDate = LocalDateTime.now();
			try {
				codeValueDTO = ClientApp.getCodeValueByCodeValueId(codeValueId);
				if (codeValueDTO != null) {
					cache.codeValueDTO = codeValueDTO;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			cachedCodeValue.put(codeValueId, cache);
			return cachedCodeValue.get(codeValueId).codeValueDTO;
		}

	}
}
