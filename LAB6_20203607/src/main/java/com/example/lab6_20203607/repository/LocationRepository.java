package com.example.lab6_20203607.repository;

import com.example.lab6_20203607.entity.Location;
import com.example.lab6_20203607.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
