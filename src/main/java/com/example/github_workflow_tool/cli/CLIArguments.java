package com.example.github_workflow_tool.cli;

import com.example.github_workflow_tool.domain.AccessToken;
import com.example.github_workflow_tool.domain.Repository;

public record CLIArguments(Repository repository, AccessToken accessToken) {
}
