package com.example.Hospital.Service;

import java.util.Map;

public interface BffService {
    String create(Map<String, String> body);

	String read(String id);

	String update(String status);

	String delete(String authHeader);
}
