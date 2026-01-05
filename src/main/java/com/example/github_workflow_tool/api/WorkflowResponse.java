package com.example.github_workflow_tool.api;

import com.example.github_workflow_tool.domain.WorkflowRun;

import java.util.List;

public record WorkflowResponse(
        int totalCount,
        List<WorkflowRun> workflowRuns
) {
}
