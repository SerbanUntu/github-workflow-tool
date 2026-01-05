package com.example.github_workflow_tool.api;

import com.example.github_workflow_tool.domain.AccessToken;
import com.example.github_workflow_tool.domain.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Abstracts the interactions with the GitHub's REST API.
 */
public class GithubClient {

    private static final String API_VERSION = "2022-11-28";

    private final HttpClient client;
    private final HttpRequest request;

    /**
     * Initializes the HTTP client and request headers and body.
     * @param repository The data object containing the GitHub repository data.
     * @param token The user's personal access token.
     * @throws URISyntaxException If an invalid URI is constructed.
     */
    public GithubClient(Repository repository, AccessToken token)
            throws URISyntaxException {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(new URI("https://api.github.com/repos/" +
                        repository.getOwner() +
                        "/" +
                        repository.getRepository() +
                        "/actions/runs"))
                .headers("X-GitHub-Api-Version", API_VERSION, "Authorization", "Bearer " + token.token())
                .build();
    }

    /**
     * Returns some mock data from the GitHub workflows API.
     * @return The raw JSON from the GitHub server, as a string.
     * @throws IOException If the client shuts down or there is an error regarding reading the data.
     * @throws InterruptedException If the operation is interrupted.
     */
    public String fetchData() throws IOException, InterruptedException {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
