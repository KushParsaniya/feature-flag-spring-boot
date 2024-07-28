
# Spring Boot Feature Flags with Unleash

## Introduction
This document describes how to set up and use feature flags in a Spring Boot application using the [Unleash](https://github.com/Unleash/unleash.git) feature flag management system. The application includes two simple endpoints that can be enabled or disabled via the Unleash dashboard.

## What are Feature Flags?
Feature flags, also known as feature toggles, are a technique that allows developers to enable or disable features in a software application without deploying new code. This enables:
- **Testing in Production**: You can safely test new features in a live environment.
- **Gradual Rollout**: Features can be gradually rolled out to users.
- **Instant Rollback**: Features can be quickly disabled if something goes wrong.
- **A/B Testing**: Different versions of a feature can be tested against each other.

## Benefits of Using Unleash
Unleash is an open-source feature flag management solution that provides:
- **Centralized Management**: A dashboard to manage feature flags across multiple applications.
- **Dynamic Feature Control**: Enable or disable features in real-time.
- **Segmentation**: Target specific groups of users for feature rollouts.

Using feature flags with Unleash helps you to:
- Test and deploy new features safely.
- Enable or disable features instantly without redeploying code.
- Manage feature rollouts effectively.
- Conduct A/B testing and gather user feedback.


## Prerequisites
- Java 8 or higher
- Maven or Gradle
- A running Unleash server (local or hosted)
 

## Installation

### Step 1: Add Unleash Dependency
Add the Unleash dependency to your `pom.xml` if you are using Maven:
```xml
<dependency>
    <groupId>io.getunleash</groupId>
    <artifactId>springboot-unleash-starter</artifactId>
    <version>1.1.0</version>
</dependency>
```

Or add the following to your build.gradle if you are using Gradle:
```gradle
implementation 'io.getunleash:springboot-unleash-starter:1.1.0'
```

### Step 2: Configuaration
Add this to your application.yml file and remeber to replace with your configuaration
```yaml
io:
  getunleash:
    app-name: feature-flag-demo
    instance-id: instance 0
    api-url: http://localhost:4242/api/
    environment: development
    api-token: default:development.unleash-insecure-api-token
```

### Step 3: Create Feature Flags
Define feature flags in the Unleash dashboard. For this example, create two feature flags, hello-flag and hi-flag. Here is image how dashboard look like: 

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)


### Step 4: Create Service
#### FlagService Interface
The `FlagService` interface defines two methods, sayHello and sayHi, which are toggled using feature flags.
It Has two implementations that are switched using feature flags.

```java
public interface FlagService {

    @Toggle(name = FlagConstant.HELLO_FLAG, alterBean = "flagServiceNew")
    String sayHello();

    @Toggle(name = FlagConstant.HI_FLAG, alterBean = "flagServiceNew")
    String sayHi();
}
```

### Step 4: Create Controller
Now you can create controller and create tow endpoint that calls tow methods from `FlagService` interface, you can see result is changes when you on or off toggle from Unleash dashboard.



## Documentation
- For more infoemation you can checkout official docs for java sdk by Unleash: 
  [Unleash Java SDK](https://docs.getunleash.io/reference/sdks/java)

- For setup Unleash Server you can follow guide here: 
  [Unleash](https://github.com/Unleash/unleash.git)


