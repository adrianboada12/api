package com.adrian.boada.api.repositories;
import  com.adrian.boada.api.entities.exam;
import org.springframework.data.jpa.repository.JpaRepository;
public interface examRepository extends JpaRepository<exam,Integer> {
}