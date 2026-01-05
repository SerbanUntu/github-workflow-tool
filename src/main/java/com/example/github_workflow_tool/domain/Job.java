package com.example.github_workflow_tool.domain;

import java.util.*;

public record Job(
        long id,
        long runId,
        String headSha,
        String status,
        String conclusion,
        String name,
        Date startedAt,
        Date completedAt,
        List<JobStep> steps
) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Job other = (Job) o;
        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.runId, other.runId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.runId);
    }
}
