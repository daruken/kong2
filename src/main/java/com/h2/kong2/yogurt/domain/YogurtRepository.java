package com.h2.kong2.yogurt.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YogurtRepository extends JpaRepository<Yogurt, Long>, YogurtRepositoryCustom {
}
