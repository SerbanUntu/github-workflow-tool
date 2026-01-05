package com.example.github_workflow_tool.cli.exceptions;

import com.example.github_workflow_tool.domain.AccessToken;

public class InvalidAccessTokenException extends CLIException {
    public InvalidAccessTokenException(AccessToken token) {
        super(
                "The token you provided is not a valid GitHub personal access token: " +
                        token.toString()
        );
    }
}
