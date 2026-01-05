package com.example.github_workflow_tool.domain;

import java.util.*;

public record JobStep(
        String name,
        String status,
        String conclusion,
        int number,
        Date startedAt,
        Date completedAt
) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        JobStep other = (JobStep) o;
        return Objects.equals(this.name, other.name) &&
                Objects.equals(this.number, other.number) &&
                Objects.equals(this.startedAt, other.startedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.number, this.startedAt);
    }
}
