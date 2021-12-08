package com.erc.his;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.erc.his.entity.AdmissionDTO;
import com.erc.his.entity.CodeDefinitionDTO;
import com.erc.his.entity.CodeValueDTO;
import com.erc.his.entity.OrganizationDTO;
import com.erc.his.entity.PatientDTO;
import com.erc.his.entity.StaffTitleDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ClientApp {

	private Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer()).create();

	public static CodeValueDTO getCodeValueByCodeValueId(Long codeValueId) throws Exception {
		return httpGetMethod("/code-value/" + codeValueId, CodeValueDTO.class);
	}

	public AdmissionDTO saveAdmission(AdmissionDTO admissionDTO) throws Exception {

		JSONObject json = new JSONObject();
		json.put("admissionId", admissionDTO.getAdmissionId());
		json.put("patientId", admissionDTO.getPatientId());
		json.put("admissionNo", admissionDTO.getAdmissionNo());
		json.put("admissionDate", admissionDTO.getAdmissionDate());
		json.put("treatmentType", admissionDTO.getTreatmentType());
		json.put("organizationId", admissionDTO.getOrganizationId());
		json.put("staffId", admissionDTO.getNote());
		json.put("note", admissionDTO.getNote());
		json.put("status", admissionDTO.getStatus());

		return postUpdateRequest("/admission/create", AdmissionDTO.class, convertObjectToJson(json));
	}

	public AdmissionDTO[] getAllAdmission() throws Exception {
		return httpGetMethod("/admission", AdmissionDTO[].class);
	}

	public AdmissionDTO updateAdmission(AdmissionDTO admissionDTO) throws Exception {
		return postUpdateRequest("/admission/update", AdmissionDTO.class, convertObjectToJson(admissionDTO));
	}

	public AdmissionDTO deleteAdmission(AdmissionDTO admissionDTO) throws Exception {
		return postUpdateRequest("/admission/delete", AdmissionDTO.class, convertObjectToJson(admissionDTO));
	}

	public ArrayList<PatientDTO> getAllPatients() throws Exception {
		PatientDTO[] patients = httpGetMethod("/patient/all", PatientDTO[].class);
		return convertToList(patients);
	}

	public ArrayList<CodeDefinitionDTO> getAllCodeDefinitions() throws Exception {
		CodeDefinitionDTO[] codeDefinitions = httpGetMethod("/code-definition/all", CodeDefinitionDTO[].class);
		return convertToList(codeDefinitions);
	}

	public ArrayList<CodeValueDTO> getAllCodeValuesByCodeDefinition(Long codeDefinitionId) throws Exception {
		CodeValueDTO[] values = httpGetMethod("/code-value/all/code-definition/" + codeDefinitionId,
				CodeValueDTO[].class);
		return convertToList(values);
	}

	public static List<CodeValueDTO> getCodeValueByCodeType(String CODETYPE) throws Exception {
		CodeValueDTO[] values = httpGetMethod("/code-value/code-definition/" + CODETYPE, CodeValueDTO[].class);
		return convertToList(values);
	}

	public ArrayList<OrganizationDTO> getAllOrganizations() throws Exception {
		OrganizationDTO[] organizations = httpGetMethod("/organization/all", OrganizationDTO[].class);
		return convertToList(organizations);
	}

	public ArrayList<StaffTitleDTO> getAllStaffTitles() throws Exception {
		StaffTitleDTO[] dtos = httpGetMethod("/staff-title/all", StaffTitleDTO[].class);
		return convertToList(dtos);
	}

	public void deletePatient(PatientDTO patientDTO) throws Exception {
		postRequest("/patient/delete", PatientDTO.class, gson.toJson(patientDTO));
	}

	private static <T> ArrayList<T> convertToList(T[] entities) {
		ArrayList<T> list = new ArrayList<T>();

		if (entities == null) {
			return list;
		}

		for (T entity : entities) {
			list.add(entity);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static <T> T httpGetMethod(String pathUrl, Class<T> clazz) throws Exception {

		URL url;
		try {
			url = new URL("http://localhost:8081" + pathUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			InputStream responseStream = connection.getInputStream();

			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				if (responseStream.available() > 0) {
					ObjectMapper mapper = new ObjectMapper();
					Object apod = mapper.readValue(responseStream, clazz);
					return (T) apod;
				} else {
					return null;
				}
			}

		} catch (ConnectException ce) {
			throw new Exception("Can not connect to the server");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	private <T> T postRequest(String pathUrl, Class<T> clazz, String data) throws Exception {

		URL url;
		try {
			url = new URL("http://localhost:8081" + pathUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("charset", "utf-8");

			byte[] postData = data.getBytes(StandardCharsets.UTF_8);
			connection.setRequestProperty("Content-Length", Integer.toString(postData.length));

			try (OutputStream os = connection.getOutputStream()) {
				os.write(postData, 0, postData.length);
			}

			int status = connection.getResponseCode();

			if (status == HttpURLConnection.HTTP_OK) {
				InputStream responseStream = connection.getInputStream();
				ObjectMapper mapper = new ObjectMapper();
				Object apod = mapper.readValue(responseStream, clazz);
				return (T) apod;
			} else if (status == HttpURLConnection.HTTP_INTERNAL_ERROR) {
				throw new Exception("HATA olustu");
			}

		} catch (ConnectException ce) {
			throw new Exception("Can not connect to server!");
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	public <T> T postUpdateRequest(String pathUrl, Class<T> clazz, String data) {

		URL url;
		try {
			url = new URL("http://localhost:8081" + pathUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
// 			connection.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("charset", "utf-8");

			byte[] postData = data.getBytes(StandardCharsets.UTF_8);
			connection.setRequestProperty("Content-Length", Integer.toString(postData.length));

			try (OutputStream os = connection.getOutputStream()) {
				os.write(postData, 0, postData.length);
			}

			InputStream responseStream = connection.getInputStream();

			ObjectMapper mapper = new ObjectMapper();
			Object apod = mapper.readValue(responseStream, clazz);
			return (T) apod;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String convertObjectToJson(Object object) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.writeValueAsString(object);
	}

	public PatientDTO savePatient(PatientDTO patientDTO) throws Exception {
		return postRequest("/patient/save", PatientDTO.class, gson.toJson(patientDTO));
	}

	public CodeDefinitionDTO saveCodeDefinition(CodeDefinitionDTO entity) throws Exception {
		return postRequest("/code-definition/save", CodeDefinitionDTO.class, gson.toJson(entity));
	}

	public void deleteCodeDefinition(CodeDefinitionDTO codeDefinitionDTO) throws Exception {
		postRequest("/code-definition/delete", CodeDefinitionDTO.class, gson.toJson(codeDefinitionDTO));
	}

	public CodeValueDTO saveCodeValueDTO(CodeValueDTO codeValueDTO) throws Exception {
		return postRequest("/code-value/save", CodeValueDTO.class, gson.toJson(codeValueDTO));
	}

	public void deleteCodeValue(CodeValueDTO codeValueDTO) throws Exception {
		postRequest("/code-value/delete", CodeValueDTO.class, gson.toJson(codeValueDTO));
	}

	public OrganizationDTO saveOrganizationDTO(OrganizationDTO organizationDTO) throws Exception {
		return postRequest("/organization/save", OrganizationDTO.class, gson.toJson(organizationDTO));
	}

	public void deleteOrganizationDTO(OrganizationDTO organizationDTO) throws Exception {
		postRequest("/organization/delete", OrganizationDTO.class, gson.toJson(organizationDTO));
	}

	public StaffTitleDTO saveStaffTitleDTO(StaffTitleDTO dto) throws Exception {
		return postRequest("/staff-title/save", StaffTitleDTO.class, gson.toJson(dto));
	}

	public void deleteStaffTitleDTO(StaffTitleDTO dto) throws Exception {
		postRequest("/staff-title/delete", StaffTitleDTO.class, gson.toJson(dto));
	}

}
