package com.id3.day_1_rest_service.soap;

import com.id3.helloworldservice.GetHelloRequest;
import com.id3.helloworldservice.GetHelloResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloWorldEndpoint {

    private static final String NAMESPACE_URI = "http://id3.com/helloworldservice";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHelloRequest")
    @ResponsePayload
    public GetHelloResponse getHello(@RequestPayload GetHelloRequest request){
        GetHelloResponse response = new GetHelloResponse();
        response.setMessage("Hello World");

        return response;
    }

}
