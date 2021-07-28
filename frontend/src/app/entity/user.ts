export class User {
  userName: String;
  password: String;
  emailId: String;
  mobileNumber: String;

  constructor(userName: String, password: String, emailId: String, mobileNumber: String) {
    this.userName = userName;
    this.password = password;
    this.emailId = emailId;
    this.mobileNumber = mobileNumber;
  }
}
