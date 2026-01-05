package com.example.github_workflow_tool.domain;

import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        WorkflowRun other = (WorkflowRun) o;
        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.workflowId, other.workflowId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.workflowId);
    }
}
