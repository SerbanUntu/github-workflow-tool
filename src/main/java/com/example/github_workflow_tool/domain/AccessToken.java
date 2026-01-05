package com.example.github_workflow_tool.domain;

/**
 * A Value Object for the user's personal GitHub Access Token.
 * @param token The token to store in the Value Object.
 */
public record AccessToken(String token) {

    /**
     * Returns the access token as a string
     * @return The token string
     */
    @Override
    public String toString() {
        return this.token;
    }
}
