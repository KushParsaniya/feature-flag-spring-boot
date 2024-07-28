package dev.kush.featureflagdemo.service;

import org.springframework.stereotype.Service;

@Service("flagServiceNew")
public class FlagServiceImplNew implements FlagService {

    @Override
    public String sayHello() {
        return "Hello, World from New!";
    }

    @Override
    public String sayHi() {
        return "Hii , From New Feature";
    }
}
