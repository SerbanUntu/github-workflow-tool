package com.example.github_workflow_tool.api;

import com.example.github_workflow_tool.domain.AccessToken;
import com.example.github_workflow_tool.domain.Repository;

import java.net.http.HttpClient;

/**
 * Abstracts the interactions with the GitHub's REST API.
 */
public abstract class GithubClient {

    private static final String API_VERSION = "2022-11-28";

    protected final HttpClient client;
    protected final String baseRoute;
    protected final String[] headers;

    /**
     * Initializes the HTTP client and request data.
     *
     * @param repository The data object containing the GitHub repository data.
     * @param token      The user's personal access token.
     */
    public GithubClient(Repository repository, AccessToken token) {
        client = HttpClient.newHttpClient();
        baseRoute = "https://api.github.com/repos/" + repository.getOwner() + "/" + repository.getRepository();
        headers = new String[]{"X-GitHub-Api-Version", API_VERSION, "Authorization", "Bearer " + token.token()};
    }
}
