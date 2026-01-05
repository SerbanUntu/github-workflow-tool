package com.example.github_workflow_tool.domain;

import java.util.*;

public class Repository implements Validatable {

    private boolean isValid;
    private final String repository;

    public Repository(String repository) {
        this.repository = repository;
        this.isValid = false;
    }

    public boolean getIsValid() {
        return this.isValid;
    }

    public String getRepository() {
        return this.repository;
    }

    @Override
    public void validate() {
        this.isValid = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Repository other = (Repository) o;
        return Objects.equals(this.isValid, other.isValid) &&
                Objects.equals(this.repository, other.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.isValid, this.repository);
    }

    @Override
    public String toString() {
        return this.repository;
    }
}
