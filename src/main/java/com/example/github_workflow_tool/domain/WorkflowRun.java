package com.example.github_workflow_tool.domain;

import java.util.Date;

public record WorkflowRun(
        long id,
        long workflowId,
        String name,
        String headBranch,
        String status,
        String conclusion,
        Date createdAt,
        Date updatedAt
) {
}
