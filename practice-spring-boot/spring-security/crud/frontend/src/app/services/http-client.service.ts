import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { Employee } from '../common/employee';

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  url: string = "http://localhost:8080";
  

  constructor(private httpClient: HttpClient) { }

  getEmployee() {
    let username = 'user';
    let password = 'a';
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });

    console.log('test call getEmployee() in HttpClientService');
    return this.httpClient.get<Employee[]>(`${this.url}/employees`)
  }
  
  deleteEmployee(employee) {
    let username = 'user';
    let password = 'a';
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    console.log('test call deleteEmployee(employee) in HttpClientService');
    return this.httpClient.delete<Employee>(`${this.url}/employees/${employee.empId}`, {headers})
  }

  createEmployee(employee) {
    let username = 'user';
    let password = 'a';
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    console.log('test call createEmployee(employee) in HttpClientService');
    return this.httpClient.post<Employee>(`${this.url}/employees/add/`, employee, {headers})
  }


}
