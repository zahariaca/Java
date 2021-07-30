import { Component, OnInit } from '@angular/core';
import { HttpClientService } from 'src/app/services/http-client.service';
import { Employee } from 'src/app/common/employee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[]

  constructor(private httpClientService: HttpClientService) { }

  ngOnInit(): void {
    this.httpClientService.getEmployee().subscribe(
      response => this.handleSuccessfulResponse(response)
    )
  }

  handleSuccessfulResponse(response) {
    this.employees = response
  }

  deleteEmployee(employee: Employee) {
    this.httpClientService.deleteEmployee(employee).subscribe(
      data => {
        this.employees = this.employees.filter(u => u !== employee)
      }
    )
  }

}
