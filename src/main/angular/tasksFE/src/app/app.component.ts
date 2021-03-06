import {Component, OnInit} from '@angular/core';
import {TaskElementModel} from "./shared/model/taskElementModel";
import {TasksService} from "./shared/service/tasks.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'tasksFE';
  tasks: TaskElementModel[] = [];
  selectedTasks: TaskElementModel[] = [];
  bug: number = 0;
  impr: number = 0;
  impl: number = 0;
  infra: number = 0;

  constructor(private service: TasksService) {
    // this.tasks = JSON.parse(`[{"type":"BUG","name":"fix bug1","deps":[]},{"type":"BUG","name":"fix bug2","deps":[]},{"type":"IMPR","name":"refactor W","deps":[]},{"type":"IMPL","name":"implement feature X","deps":["fix bug2","refactor W"]},{"type":"INFRA","name":"release","deps":["fix bug1","fix bug2","implement feature X"]},{"type":"INFRA","name":"deploy","deps":["release"]}]`);

  }

  ngOnInit(): void {
    this.service.listAllTasks().subscribe(data => {
      this.tasks = data;
      for (let i = 0; i < data.length; i++) {
        this.typeSelector(data[i]);
      }
    });
  }

  calculateSelected(event: any) {
    this.selectedTasks = event.value;
    this.bug = 0;
    this.impl = 0;
    this.infra = 0;
    this.impr = 0;
    for (let i = 0; i < this.tasks.length; i++) {
      let task = this.tasks[i];
      if (!this.selectedTasks.includes(task)) {
        this.typeSelector(task);
      }
    }
  }

  typeSelector(task: TaskElementModel) {
    if (task.type.toLocaleLowerCase() === 'bug') {
      this.bug++;
    } else if (task.type.toLocaleLowerCase() === 'impr') {
      this.impr++;
    } else if (task.type.toLocaleLowerCase() === 'impl') {
      this.impl++;
    } else if (task.type.toLocaleLowerCase() === 'infra') {
      this.infra++;
    }
  }
}
