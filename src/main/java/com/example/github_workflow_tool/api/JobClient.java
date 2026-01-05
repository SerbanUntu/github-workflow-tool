package com.example.github_workflow_tool.api;

import com.example.github_workflow_tool.domain.AccessToken;
import com.example.github_workflow_tool.domain.Repository;
import com.example.github_workflow_tool.json.JsonService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JobClient extends GithubClient {

    private static String getRoute(long runId) {
        return "/actions/runs/" + runId + "/jobs";
    }

    public JobClient(Repository repository, AccessToken accessToken) {
        super(repository, accessToken);
    }

    public JobResponse fetchData(long runId) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(baseRoute + getRoute(runId)))
                .headers(headers)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return (new JsonService()).parseJobResponse(response.body());
    }
}
