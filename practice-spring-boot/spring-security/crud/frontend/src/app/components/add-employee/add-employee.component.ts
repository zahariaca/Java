import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/common/employee';
import { HttpClientService } from 'src/app/services/http-client.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  user: Employee = new Employee(undefined,"","","")

  constructor(private httpClientService: HttpClientService) { }

  ngOnInit(): void {
  }


  createEmployee(): void {
    this.httpClientService.createEmployee(this.user)
      .subscribe( data => { alert("Employee created successfully")})
  }
}
