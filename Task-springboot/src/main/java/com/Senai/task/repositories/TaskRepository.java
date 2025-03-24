package com.Senai.task.repositories;

import com.Senai.task.models.TaskModel;
import com.Senai.task.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    Optional<UserModel> findByUsuario(UserModel Usuario);
}
