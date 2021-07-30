import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { User } from '../common/user';
import { map} from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) { }

  authenticate(username,password) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.httpClient.get<User>('http://localhost:8080/employees/validateLogin', {headers}).pipe(
      map(
        userData => {
          console.log('++authenticate: ' + userData)
          sessionStorage.setItem('username', username)
          return userData
        }
      )
    )
  }

  isUserLoggedIn() {
    let user= sessionStorage.getItem('username');
    return !(user===null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}
