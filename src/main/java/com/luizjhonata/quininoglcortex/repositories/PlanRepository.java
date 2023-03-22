package com.luizjhonata.quininoglcortex.repositories;

import com.luizjhonata.quininoglcortex.models.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
}
