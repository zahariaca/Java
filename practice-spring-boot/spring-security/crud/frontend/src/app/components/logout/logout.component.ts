import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
    this.authenticationService.logOut();
    this.router.navigate(['login'])
  }

}
