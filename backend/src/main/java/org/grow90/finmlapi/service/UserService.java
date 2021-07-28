package org.grow90.finmlapi.service;

import org.grow90.finmlapi.model.user.CheckUserExistRequest;
import org.grow90.finmlapi.model.user.CheckUserExistResponse;
import org.grow90.finmlapi.model.user.SignUpRequest;
import org.grow90.finmlapi.model.user.SignUpResponse;

public interface UserService {

    SignUpResponse signUp(SignUpRequest signUpRequest);

    CheckUserExistResponse isUserNameExist(CheckUserExistRequest checkUserExistRequest);

    void verifyMailId(int userId);
}
