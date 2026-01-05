package com.example.github_workflow_tool.api;

import com.example.github_workflow_tool.domain.Job;

import java.util.List;

public record JobResponse(
        int totalCount,
        List<Job> jobs
) {
}
