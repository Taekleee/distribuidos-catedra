package com.comisaria.distribuidos.repositories;

import java.util.ArrayList;

import com.comisaria.distribuidos.models.TemporaryPass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface TemporaryPassRepository extends JpaRepository<TemporaryPass, Long> {
    ArrayList<TemporaryPass> findAll();
}
