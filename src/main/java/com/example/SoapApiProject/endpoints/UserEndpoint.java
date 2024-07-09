package com.example.SoapApiProject.endpoints;
import com.example.SoapApiProject.service.UserService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import java.util.Optional;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/SoapApiProject/user";

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
    @ResponsePayload
    public void createUser(@RequestPayload com.example.soapapiproject.user.CreateUserRequest request) {

        userService.createUser(request.getUser());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "readUserRequest")
    @ResponsePayload
    public com.example.soapapiproject.user.ReadUserResponse readUser(@RequestPayload com.example.soapapiproject.user.ReadUserRequest request) {
        com.example.soapapiproject.user.ReadUserResponse readUserResponse = new com.example.soapapiproject.user.ReadUserResponse();
        readUserResponse.setUser(userService.readUser(request.getUserId()));
        return readUserResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public com.example.soapapiproject.user.UpdateUserResponse updateUser(@RequestPayload com.example.soapapiproject.user.UpdateUserRequest request) {
        com.example.soapapiproject.user.UpdateUserResponse updateUserResponse = new com.example.soapapiproject.user.UpdateUserResponse();
        updateUserResponse.setUser(userService.updateUser(request.getUser()));
        return updateUserResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    @ResponsePayload
    public void deleteUser(@RequestPayload com.example.soapapiproject.user.DeleteUserRequest request) {
        userService.deleteUser(request.getUserId());
    }
}
