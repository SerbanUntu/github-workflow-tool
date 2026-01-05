package com.example.github_workflow_tool.api;

import com.example.github_workflow_tool.domain.AccessToken;
import com.example.github_workflow_tool.domain.Job;
import com.example.github_workflow_tool.domain.Repository;
import com.example.github_workflow_tool.domain.WorkflowRun;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class WorkflowService {

    private final JobClient jobClient;
    private final WorkflowClient workflowClient;

    public WorkflowService(Repository repository, AccessToken accessToken) throws URISyntaxException {
        this.jobClient = new JobClient(repository, accessToken);
        this.workflowClient = new WorkflowClient(repository, accessToken);
    }

    public Map<WorkflowRun, List<Job>> queryApi() throws IOException, InterruptedException, URISyntaxException {
        Map<WorkflowRun, List<Job>> result = new HashMap<>();
        WorkflowResponse workflowResponse = this.workflowClient.fetchData();
        for (WorkflowRun run : workflowResponse.workflowRuns()) {
            JobResponse jobResponse = this.jobClient.fetchData(run.id());
            result.put(run, jobResponse.jobs());
        }
        return result;
    }
}
