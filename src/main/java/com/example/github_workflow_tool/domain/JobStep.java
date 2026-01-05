package com.example.github_workflow_tool.domain;

import java.util.*;

/**
 * The execution state of a step inside a job
 */
public record JobStep(
        String name,
        String status,
        String conclusion,
        int number,
        Date startedAt,
        Date completedAt
) {
}
