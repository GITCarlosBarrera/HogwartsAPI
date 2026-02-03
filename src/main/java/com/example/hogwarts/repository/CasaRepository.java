package com.example.hogwarts.repository;

import com.example.hogwarts.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasaRepository extends JpaRepository<Casa, Integer> {
}
