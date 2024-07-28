package dev.kush.featureflagdemo.service;


import dev.kush.featureflagdemo.constant.FlagConstant;
import org.unleash.features.annotation.Toggle;

public interface FlagService {

    @Toggle(name = FlagConstant.HELLO_FLAG, alterBean = "flagServiceNew")
    String sayHello();

    @Toggle(name = FlagConstant.HI_FLAG, alterBean = "flagServiceNew")
    String sayHi();
}