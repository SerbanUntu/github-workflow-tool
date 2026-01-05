package com.example.github_workflow_tool.json;

import com.example.github_workflow_tool.api.JobResponse;
import com.example.github_workflow_tool.api.WorkflowResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonService {

    private final Gson gson;

    public JsonService() {
        this.gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    public WorkflowResponse parseWorkflowResponse(String json) {
        return this.gson.fromJson(json, WorkflowResponse.class);
    }

    public JobResponse parseJobResponse(String json) {
        return this.gson.fromJson(json, JobResponse.class);
    }
}
