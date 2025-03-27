package com.Senai.task.repositories;

import com.Senai.task.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    boolean existsByUserModel_Email(String email);
    Optional<TaskModel> findByUserModel_EmailAndDataDeAgendamento(String email, LocalDate data);
    Optional<TaskModel>findById(Long id);
}
