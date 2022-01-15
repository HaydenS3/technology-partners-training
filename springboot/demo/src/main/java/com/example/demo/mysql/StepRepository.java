package com.example.demo.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.mysql.Step;

public interface StepRepository extends JpaRepository<Step, Long> {

}
