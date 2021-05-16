package com.example.demo.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.demo.whitetest.StudentRequest;
import com.example.demo.whitetest.WhiteTestResponse;

@Service
public class SoapStudent {
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate serviceTemplate;
	
	public WhiteTestResponse getWhiteTestStatus(StudentRequest request) {
		serviceTemplate = new WebServiceTemplate(marshaller);
		WhiteTestResponse response =(WhiteTestResponse) serviceTemplate
				.marshalSendAndReceive("http://localhost:8090/wt", request);
		return response;
	}

}
