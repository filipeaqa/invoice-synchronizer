package com.api.challenge.invoicesynchronizer.repository;

import com.api.challenge.invoicesynchronizer.entity.CursorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursorRepository extends JpaRepository<CursorEntity,Long > {

    Optional<CursorEntity> findFirstByOrderByIdDesc();

}
