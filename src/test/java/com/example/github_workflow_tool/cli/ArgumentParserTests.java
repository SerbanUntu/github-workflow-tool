package com.example.github_workflow_tool.cli;

import static org.junit.jupiter.api.Assertions.*;

import com.example.github_workflow_tool.cli.exceptions.TooFewArgumentsException;
import com.example.github_workflow_tool.cli.exceptions.TooManyArgumentsException;
import com.example.github_workflow_tool.domain.AccessToken;
import com.example.github_workflow_tool.domain.Repository;
import org.junit.jupiter.api.Test;

public class ArgumentParserTests {

    private final ArgumentParser sut = new ArgumentParser();

    @Test
    public void parseNullTest() {
        assertThrows(TooFewArgumentsException.class, () -> sut.parse(null));
    }

    @Test
    public void tooFewArgumentsTest() {
        String[] args = {"arg1"};
        assertThrows(TooFewArgumentsException.class, () -> sut.parse(args));
    }

    @Test
    public void tooManyArgumentsTest() {
        String[] args = {"arg1", "arg2", "arg3"};
        assertThrows(TooManyArgumentsException.class, () -> sut.parse(args));
    }

    @Test
    public void parseTwoArgumentsCorrectlyTest() {
        String[] args = {"repoName", "accessToken"};
        CLIArguments expected = new CLIArguments(
                new Repository("repoName"),
                new AccessToken("accessToken")
        );
        assertEquals(expected, sut.parse(args));
    }
}
