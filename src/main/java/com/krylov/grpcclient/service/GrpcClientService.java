package com.krylov.grpcclient.service;

import com.example.grpc.GreetingServiceGrpc.GreetingServiceBlockingStub;
import com.example.grpc.GreetingServiceOuterClass.HelloRequest;
import com.example.grpc.GreetingServiceOuterClass.HelloResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

@GrpcClient("MyGrpcService")
  private GreetingServiceBlockingStub greetingServiceBlockingStub;


  public String sayHello(String name, String surname){
    HelloRequest request = HelloRequest.newBuilder()
        .setName(name)
        .setSurName(surname)
        .build();

    HelloResponse response = greetingServiceBlockingStub.greeting(request);
      return response.getGreeting();
  }
}
