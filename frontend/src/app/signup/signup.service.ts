import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../entity/user";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SignupService {
  constructor(private _http: HttpClient) {
  }

  public siginUpUser(user: User): Observable<any> {
    console.log(user)
    return this._http.post('http://localhost:8080/user/signUp',user)
  }

}
