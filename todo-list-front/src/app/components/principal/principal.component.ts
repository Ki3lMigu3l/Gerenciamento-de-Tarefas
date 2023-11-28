import { Component, Input, OnInit } from '@angular/core';
import { Tarefa } from 'src/app/model/Tarefa';
import { TarefaService } from 'src/app/service/tarefa.service';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit{

  tarefas: Tarefa[] = [];

  constructor(private service: TarefaService) { }

  obterTasks(): void {
    this.service.obterTasks().subscribe(retorno => this.tarefas = retorno);
    console.log(this.tarefas)
  }

  ngOnInit(): void {
    this.obterTasks();
  }
}
