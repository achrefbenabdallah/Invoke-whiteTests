package com.example.demo.client.service;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.demo.whitetest.StudentRequest;
import com.example.demo.whitetest.WhiteTestResponse;

@Service
public class SoapStudent {
	
	private Jaxb2Marshaller marshaller;
	private WebServiceTemplate serviceTemplate;
	
	public WhiteTestResponse getWhiteTestStatus(StudentRequest request) {
		serviceTemplate = new WebServiceTemplate(marshaller);
		WhiteTestResponse response =(WhiteTestResponse) serviceTemplate
				.marshalSendAndReceive("http://localhost:8090/wt", request);
		return response;
	}

}
