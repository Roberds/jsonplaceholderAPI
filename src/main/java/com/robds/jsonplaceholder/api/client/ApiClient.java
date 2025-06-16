package com.robds.jsonplaceholder.api.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ApiClient {

	private final HttpClient client;
	private final String URL_BASE = "https://jsonplaceholder.typicode.com";

	public ApiClient() {
		this.client = HttpClient.newHttpClient();
	}

	public HttpResponse<String> connectUserById(Long id) throws IOException, InterruptedException {
		String url = String.format(URL_BASE + "/users/%s", id);
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		return response;

	}

	public HttpResponse<String> connectPotsUserById(Long userId) throws IOException, InterruptedException {
		String url = String.format(URL_BASE + "/posts?userId=%s", userId);
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		return response;

	}

}
