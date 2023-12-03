import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tarefa } from '../model/Tarefa';

@Injectable({
  providedIn: 'root'
})
export class TarefaService {

  private apiUrl: string = 'http://localhost:8080/tasks';

  constructor(private http:HttpClient) { }

  obterTasks(): Observable<Tarefa[]> {
    return this.http.get<Tarefa[]>(this.apiUrl);
  }

}
