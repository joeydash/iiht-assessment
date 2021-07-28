package org.grow90.finmlapi.serviceImpl;

import org.grow90.finmlapi.entity.User;
import org.grow90.finmlapi.exceptionutility.DatabaseException;
import org.grow90.finmlapi.exceptionutility.UserNotFoundException;
import org.grow90.finmlapi.model.user.CheckUserExistRequest;
import org.grow90.finmlapi.model.user.CheckUserExistResponse;
import org.grow90.finmlapi.model.user.SignUpRequest;
import org.grow90.finmlapi.model.user.SignUpResponse;
import org.grow90.finmlapi.repository.UserRepository;
import org.grow90.finmlapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Value("${mail.verification.server.url}")
    private String mail_server_url;
    @Value("${mail.verification.url.host}")
    private String mail_verification_url;

    private void sendMail(User user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(mail_server_url))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\n\t\"userName\": \"" + user.getUserName() + "\",\n\t\"emailId\": \"" + user.getEmailId() + "\",\n\t\"verificationLink\": \"" + mail_verification_url + user.getId() + "\"\n}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
    }

    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        try {
            User user = userRepository.save(new User(signUpRequest.getUserName(), signUpRequest.getPassword(), signUpRequest.getEmailId(), signUpRequest.getMobileNumber()));
            sendMail(user);
            if (user != null) {
                return new SignUpResponse(true);
            } else {
                throw  new Exception("User could not be created");
            }
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    @Override
    public CheckUserExistResponse isUserNameExist(CheckUserExistRequest checkUserExistRequest) {
        User user = userRepository.findByUserName(checkUserExistRequest.getUserName());
        if (user != null) {
            return new CheckUserExistResponse(true);
        } else {
            return new CheckUserExistResponse(false);
        }
    }

    @Override
    public void verifyMailId(int userId) {
        User existingUser = userRepository.findById(userId).orElse(null);
        existingUser.setConfirmed(true);
        userRepository.save(existingUser);
    }
}
