package com.example.github_workflow_tool.api;

import com.example.github_workflow_tool.domain.AccessToken;
import com.example.github_workflow_tool.domain.Repository;
import com.example.github_workflow_tool.json.JsonService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WorkflowClient extends GithubClient {

    private static final String route = "/actions/runs";

    private final HttpRequest request;

    public WorkflowClient(Repository repository, AccessToken accessToken)
            throws URISyntaxException {
        super(repository, accessToken);
        this.request = HttpRequest.newBuilder()
                .uri(new URI(baseRoute + route))
                .headers(headers)
                .build();
    }

    public WorkflowResponse fetchData() throws IOException, InterruptedException {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return (new JsonService()).parseWorkflowResponse(response.body());
    }
}
