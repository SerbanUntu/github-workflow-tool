package com.example.github_workflow_tool.domain;

import java.util.*;

/**
 * The execution state of a job inside a workflow run
 */
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
}
