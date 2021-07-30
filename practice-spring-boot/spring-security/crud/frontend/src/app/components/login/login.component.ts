import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username="user"
  password="a"
  invalidLogin = false

  constructor(private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
  }

  checkLogin() {
    this.authenticationService.authenticate(this.username, this.password).subscribe(
      data => {
        console.log(`++checkLogin: ${data}`)
        this.router.navigate(['']);
        this.invalidLogin = false;
      },
      error => {
        console.log(`++checkLogin: ${error}`)
        this.invalidLogin = true;
      }
    )
  }

}
