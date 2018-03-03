package com.unesco.core.repositories.plan;

import com.unesco.core.entities.Plan;
import com.unesco.core.entities.Semester;
import org.springframework.data.repository.CrudRepository;

public interface SemesterRepository extends CrudRepository<Semester, Long> {
    public Semester findByPlanId(Long planId);
}