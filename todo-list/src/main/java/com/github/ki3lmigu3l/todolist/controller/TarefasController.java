package com.github.ki3lmigu3l.todolist.controller;

import com.github.ki3lmigu3l.todolist.dto.TarefaRecordDto;
import com.github.ki3lmigu3l.todolist.model.Tarefa;
import com.github.ki3lmigu3l.todolist.service.TarefaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
public class TarefasController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa createTask(@RequestBody TarefaRecordDto taskDto){
        var tarefa = new Tarefa();
        BeanUtils.copyProperties(taskDto, tarefa);
        return tarefaService.saveTask(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.findAllTasks());
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateTaskById (@PathVariable Long id, @RequestBody TarefaRecordDto tarefaDto) {
        Optional<Tarefa> tarefaOptional = tarefaService.findTaskById(id);

        if (tarefaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
        }

        var tarefa = tarefaOptional.get();
        BeanUtils.copyProperties(tarefaDto, tarefa);
        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.saveTask(tarefa));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteTaskById (@PathVariable Long id) {
        Optional<Tarefa> tarefaOptional = tarefaService.findTaskById(id);

        if (tarefaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
        }

        tarefaService.deleteTask(tarefaOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Tarefa excluida com exito");
    }
}
