import {Component, OnInit} from '@angular/core';
import {SignupService} from "./signup.service";
import {User} from "../entity/user";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user: User = new User("", "", "", "");

  constructor(private _signUpService: SignupService) {
  }

  ngOnInit(): void {
  }

  siginUpUser() {
    console.log(this.user);
    this._signUpService.siginUpUser(this.user).subscribe(
      data => console.log(data),
      error => console.log(error)
    )
  }
}
