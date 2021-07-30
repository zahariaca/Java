import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http'
import { Employee } from '../common/employee';

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  url: string = "http://localhost:8080";

  constructor(private httpClient: HttpClient) { }

  getEmployee() {
    console.log('test call getEmployee() in HttpClientService');
    return this.httpClient.get<Employee[]>(`${this.url}/employees`)
  }
  
  deleteEmployee(employee) {
    console.log('test call deleteEmployee(employee) in HttpClientService');
    return this.httpClient.delete<Employee>(`${this.url}/employees/${employee.empId}`)
  }

  createEmployee(employee) {
    console.log('test call createEmployee(employee) in HttpClientService');
    return this.httpClient.post<Employee>(`${this.url}/employees/add/`, employee)
  }


}
