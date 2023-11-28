package com.github.ki3lmigu3l.todolist.repository;

import com.github.ki3lmigu3l.todolist.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
