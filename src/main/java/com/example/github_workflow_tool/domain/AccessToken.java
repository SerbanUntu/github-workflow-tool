package com.example.github_workflow_tool.domain;

import java.util.*;

public class AccessToken implements Validatable {

    private boolean isValid;
    private final String token;

    public AccessToken(String token) {
        this.token = token;
        this.isValid = false;
    }

    public boolean getIsValid() {
        return this.isValid;
    }

    public String getToken() {
        return this.token;
    }

    @Override
    public void validate() {
        this.isValid = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AccessToken other = (AccessToken) o;
        return Objects.equals(this.isValid, other.isValid) &&
                Objects.equals(this.token, other.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.isValid, this.token);
    }

    @Override
    public String toString() {
        return this.token;
    }
}
