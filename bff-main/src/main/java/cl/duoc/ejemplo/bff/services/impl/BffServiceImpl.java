package cl.duoc.ejemplo.bff.services.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import cl.duoc.ejemplo.bff.restclients.ClienteRest;
import cl.duoc.ejemplo.bff.services.BffService;

@Service
public class BffServiceImpl implements BffService {

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
