package dev.kush.featureflagdemo.service;

import dev.kush.featureflagdemo.constant.FlagConstant;
import dev.kush.featureflagdemo.exception.FlagException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("flagService")
@Qualifier
public class FlagServiceImpl implements FlagService {

    @Override
    public String sayHello() {
        return "Hello, World!";
    }

    @Override
    public String sayHi() {
        throw new FlagException(FlagConstant.HI_FLAG);
    }
}
