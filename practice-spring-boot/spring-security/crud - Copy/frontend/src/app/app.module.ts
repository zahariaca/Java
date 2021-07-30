import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddEmployeeComponent } from './components/add-employee/add-employee.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';

const routes: Routes = [
  { path: 'employee', component: EmployeeComponent },
  { path:'addemployee', component: AddEmployeeComponent},
  { path: '', component: EmployeeComponent },
  { path: '**', component: EmployeeComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    AddEmployeeComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    NgbModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
