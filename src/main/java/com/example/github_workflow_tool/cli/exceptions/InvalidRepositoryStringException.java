package com.example.github_workflow_tool.cli.exceptions;

import com.example.github_workflow_tool.domain.Repository;

public class InvalidRepositoryStringException extends CLIException {
    public InvalidRepositoryStringException(Repository repository) {
        super(
                "The repository name you provided is not a valid GitHub repository, or it does not belong to your account: " +
                        repository.toString()
        );
    }
}
