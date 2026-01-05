package com.example.github_workflow_tool;

import com.example.github_workflow_tool.cli.ArgumentParser;
import com.example.github_workflow_tool.cli.CLIArguments;

public class GithubWorkflowToolApplication {

    public static void main(String[] args) {
        try {
            CLIArguments parsedArgs = (new ArgumentParser()).parse(args);
            System.out.println("Repository: " +
                    parsedArgs.repository() +
                    "\nAccess token: " +
                    parsedArgs.accessToken());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}