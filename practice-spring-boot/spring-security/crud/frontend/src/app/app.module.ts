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
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { AuthGuardService } from './services/auth-guard.service';

const routes: Routes = [
  { path: 'employee', component: EmployeeComponent, canActivate: [AuthGuardService] },
  { path: 'addemployee', component: AddEmployeeComponent, canActivate: [AuthGuardService] },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent, canActivate: [AuthGuardService] },
  { path: '', component: EmployeeComponent, canActivate: [AuthGuardService] },
  { path: '**', component: EmployeeComponent, canActivate: [AuthGuardService] }
];

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    AddEmployeeComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    LogoutComponent
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
