package com.example.github_workflow_tool.api;

import com.example.github_workflow_tool.cli.exceptions.CLIException;
import com.example.github_workflow_tool.cli.exceptions.InexistentRepositoryException;
import com.example.github_workflow_tool.cli.exceptions.InvalidAccessTokenException;
import com.example.github_workflow_tool.domain.AccessToken;
import com.example.github_workflow_tool.domain.Repository;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;

/**
 * Abstracts the interactions with the GitHub's REST API.
 */
public abstract class GithubClient {

    private static final String API_VERSION = "2022-11-28";

    protected final Repository repository;
    protected final HttpClient client;

    /**
     * The route shared by all requests. Contains the base URL, the owner, and the repository name
     */
    protected final String baseRoute;

    /**
     * The headers needed when sending requests to the GitHub API, in the form: header vale header value
     */
    protected final String[] headers;

    /**
     * Throws a CLI exception if the API returns a 4xx status code due to incorrect parameters passed to the CLI
     * @param response The HTTP Response object
     * @throws CLIException If the repository is not found or the access token is invalid
     */
    protected void checkResponse(HttpResponse<String> response) throws CLIException {
        switch (response.statusCode()) {
            case 401:
                throw new InvalidAccessTokenException();
            case 404:
                throw new InexistentRepositoryException(repository);
        }
    }

    /**
     * Initializes the HTTP client and request data.
     *
     * @param repository The data object containing the GitHub repository data.
     * @param token      The user's personal access token.
     */
    public GithubClient(Repository repository, AccessToken token) {
        this.repository = repository;
        client = HttpClient.newHttpClient();
        baseRoute = "https://api.github.com/repos/" + repository.getOwner() + "/" + repository.getRepository();
        headers = new String[]{"X-GitHub-Api-Version", API_VERSION, "Authorization", "Bearer " + token.token()};
    }
}
