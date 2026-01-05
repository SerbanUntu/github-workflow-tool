package com.example.github_workflow_tool;

import com.example.github_workflow_tool.api.GithubClient;
import com.example.github_workflow_tool.cli.ArgumentParser;
import com.example.github_workflow_tool.cli.CLIArguments;

/**
 * The CLI application class. Contains the main() method which starts the application.
 */
public class GithubWorkflowToolApplication {

    /**
     * The starting point of the application.
     * @param args The arguments passed to the CLI. Should be owner/repo and accessToken.
     */
    public static void main(String[] args) {
        try {
            CLIArguments parsedArgs = (new ArgumentParser()).parse(args);
            GithubClient ghClient = new GithubClient(parsedArgs.repository(), parsedArgs.accessToken());
            System.out.println(ghClient.fetchData());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}