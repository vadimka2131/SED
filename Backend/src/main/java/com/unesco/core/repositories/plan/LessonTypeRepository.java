package com.unesco.core.repositories.plan;

import com.unesco.core.entities.plan.LessonType;
import com.unesco.core.repositories.utils.CrudPagableRepository;
import org.springframework.data.repository.CrudRepository;

public interface LessonTypeRepository extends CrudRepository<LessonType, Long>, CrudPagableRepository<LessonType, Long> {
}
