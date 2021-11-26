package com.erc.his;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.JSONObject;

import com.erc.his.entity.AdmissionDTO;
import com.erc.his.entity.PatientDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.google.gson.Gson;

public class ClientApp {
	
	private Gson gson = new Gson();
	
	public static void main(String... args) {

		ClientApp app = new ClientApp();
//		AppointmentDTO[] result = app.makeRequest("/appointments", AppointmentDTO[].class);
//		for (AppointmentDTO appointmentDTO : result) {
//			System.out.println(appointmentDTO.getScalarDoctorName() + " " + appointmentDTO.getScalarDoctorLastName());
//		}
	}
 
 
	//**************************** A D M I S S I O N **************************
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
	public AdmissionDTO[] getAllAdmission() {
		return httpGetMethod("/admission", AdmissionDTO[].class);
	}
	public AdmissionDTO updateAdmission(AdmissionDTO admissionDTO) throws Exception {
		return postUpdateRequest("/admission/update", AdmissionDTO.class, convertObjectToJson(admissionDTO));
	}
	public AdmissionDTO deleteAdmission(AdmissionDTO admissionDTO) throws Exception {
		return postUpdateRequest("/admission/delete", AdmissionDTO.class, convertObjectToJson(admissionDTO));
	}
	
	
	public ArrayList<PatientDTO> getAllPatients() {
		PatientDTO[] patients = httpGetMethod("/patient/all", PatientDTO[].class);
		convertToList(patients);
		return convertToList(patients);
	}
		
	private <T> ArrayList<T> convertToList(T[] entities) {
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
	public <T> T httpGetMethod(String pathUrl, Class<T> clazz) {
 
		URL url;
		try {
			url = new URL("http://localhost:8081" + pathUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
 			InputStream responseStream = connection.getInputStream();
 			
 			if(responseStream.available()>0) {
 				ObjectMapper mapper = new ObjectMapper();
 				Object apod = mapper.readValue(responseStream, clazz);
 				return (T) apod;
 			}else {
 				return null;
 			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@SuppressWarnings("unchecked")
	private <T> T postRequest(String pathUrl, Class<T> clazz, String data) {
		 
		URL url;
		try {
			url = new URL("http://localhost:8081" + pathUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
 			connection.setRequestProperty( "Content-Type", "application/json");
 			connection.setRequestProperty( "charset", "utf-8");
 			
 			
 			byte[] postData = data.getBytes(StandardCharsets.UTF_8 );
 			connection.setRequestProperty( "Content-Length", Integer.toString( postData.length ));
			
			try(OutputStream os = connection.getOutputStream()) {
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
	@SuppressWarnings("unchecked")
	public <T> T postUpdateRequest(String pathUrl, Class<T> clazz, String data) {
		 
		URL url;
		try {
			url = new URL("http://localhost:8081" + pathUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
// 			connection.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
 			connection.setRequestProperty( "Content-Type", "application/json");
 			connection.setRequestProperty( "charset", "utf-8");
 			
 			
 			byte[] postData = data.getBytes(StandardCharsets.UTF_8 );
 			connection.setRequestProperty( "Content-Length", Integer.toString( postData.length ));
			
			try(OutputStream os = connection.getOutputStream()) {
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
	public static String convertObjectToJson(Object object) throws Exception{
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.writeValueAsString(object);
	}

	public PatientDTO savePatient(PatientDTO patientDTO) throws Exception {
		return postRequest("/patient/save", PatientDTO.class, gson.toJson(patientDTO));
	}


	
}
