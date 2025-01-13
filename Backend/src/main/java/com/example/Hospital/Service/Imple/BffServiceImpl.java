package com.example.Hospital.Service.Imple;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.example.Hospital.Service.BffService;
import com.example.Hospital.restclients.ClienteRest;

@Service
public class BffServiceImpl implements BffService{
    
    private final ClienteRest clienteRest;

	public BffServiceImpl(ClienteRest clienteRest) {

		this.clienteRest = clienteRest;
	}

	public String create(Map<String, String> body) {
		return clienteRest.create(body);
	}

	public String read(String id) {
		return clienteRest.read(id);
	}

	public String update(String status) {
		return clienteRest.update(status);
	}

	public String delete(String authHeader) {
		return clienteRest.delete(authHeader);
	}
}
