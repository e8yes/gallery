package org.e8.healthchecker.repository;

import org.e8.healthchecker.entity.HealthCheckerEntity;
import org.springframework.data.repository.CrudRepository;

public interface HealthCheckerRepository extends
        CrudRepository<HealthCheckerEntity, String> {
}
