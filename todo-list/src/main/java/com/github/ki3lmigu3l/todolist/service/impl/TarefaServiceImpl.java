package com.github.ki3lmigu3l.todolist.service.impl;

import com.github.ki3lmigu3l.todolist.model.Tarefa;
import com.github.ki3lmigu3l.todolist.repository.TarefaRepository;
import com.github.ki3lmigu3l.todolist.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;


    @Override
    public Tarefa saveTask(Tarefa task) {
        return tarefaRepository.save(task);
    }

    @Override
    public List<Tarefa> findAllTasks() {
        return tarefaRepository.findAll();
    }

    @Override
    public Optional<Tarefa> findTaskById(Long id) {
        return tarefaRepository.findById(id);
    }

    @Override
    public void deleteTask(Tarefa tarefa) {
        tarefaRepository.delete(tarefa);
    }

}
