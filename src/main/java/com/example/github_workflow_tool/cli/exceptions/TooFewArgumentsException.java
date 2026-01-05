package com.example.github_workflow_tool.cli.exceptions;

public class TooFewArgumentsException extends CLIException {
    public TooFewArgumentsException(int numberOfArguments) {
        super("Too few arguments provided to the command. Expected 2, got " + numberOfArguments + ".");
    }
}
