import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class TasksService {
  constructor(private http: HttpClient) {
  }

  listAllTasks():Observable<any> {
    return this.http.get('http://localhost:8080/api/tasks')
  }
}
