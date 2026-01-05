package com.example.github_workflow_tool.cli.exceptions;

/**
 * Thrown when the user enters less than two arguments in the command line.
 */
public class InvalidRepositoryStringException extends CLIException {
    public InvalidRepositoryStringException(String repositoryString) {
        super(
                "The owner/repo pair you provided is not a valid, or you do not have read access for that repository: " +
                        repositoryString
        );
    }
}
