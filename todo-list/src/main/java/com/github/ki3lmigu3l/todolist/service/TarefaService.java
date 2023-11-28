package com.github.ki3lmigu3l.todolist.service;

import com.github.ki3lmigu3l.todolist.model.Tarefa;

import java.util.List;
import java.util.Optional;

public interface TarefaService {
    Tarefa saveTask(Tarefa task);

    List<Tarefa> findAllTasks();

    Optional<Tarefa> findTaskById(Long id);

    void deleteTask(Tarefa tarefa);
}
