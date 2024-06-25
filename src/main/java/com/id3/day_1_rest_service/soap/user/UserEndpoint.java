package com.id3.day_1_rest_service.soap.user;


import com.id3.day_1_rest_service.helper.mapping.IJpa2JaxbMapper;
import com.id3.day_1_rest_service.model.entity.User;
import com.id3.day_1_rest_service.service.IUserService;
import com.id3.helloworldservice.*;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
@RequiredArgsConstructor
public class UserEndpoint {
    private final IUserService userService;

    private static final String NAMESPACE_URI = "http://id3.com/helloworldservice";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUsersRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsers(){
        List<User> users = userService.getAll();
        GetAllUsersResponse response = new GetAllUsersResponse();
        for(User user : users){
            com.id3.helloworldservice.User user1 = IJpa2JaxbMapper.INSTANCE.jpa2JaxbUser(user);

            response.getUsers().add(user1);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByIdRequest")
    @ResponsePayload
    public GetUserByIdResponse getUserById(@RequestPayload GetUserByIdRequest request){
        User user = userService.getUserById(request.getId()).orElseThrow();

        GetUserByIdResponse response = new GetUserByIdResponse();
        com.id3.helloworldservice.User user1 = IJpa2JaxbMapper.INSTANCE.jpa2JaxbUser(user);

        response.setUser(user1);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
    @ResponsePayload
    public CreateUserResponse createUser(@RequestPayload CreateUserRequest request){
        User user = IJpa2JaxbMapper.INSTANCE.jaxb2jpaUser(request.getUser());
        userService.createUser(user);

        CreateUserResponse response = new CreateUserResponse();
        response.setMessage("User Created Successfully");

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request){
        User user = IJpa2JaxbMapper.INSTANCE.jaxb2jpaUser(request.getUser());
        userService.createUser(user);

        UpdateUserResponse response = new UpdateUserResponse();
        response.setMessage("User Updated Successfully");

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse updateUser(@RequestPayload DeleteUserRequest request){
        userService.deleteUser(request.getId());

        DeleteUserResponse response = new DeleteUserResponse();
        response.setMessage("User Deleted Successfully");

        return response;
    }








}
