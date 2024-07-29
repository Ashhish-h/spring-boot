# The Project is for learning some feature of spring-boot-devtools

The spring-boot-devtools dependency is designed to improve the development experience by providing several features that make it easier to develop, test, and debug Spring Boot applications.

## Dependencies 

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>

## Key Features

### Automatic Restart:

#### Description: 
Enables automatic restarts whenever files in the classpath change. This feature is very useful for developers because it allows them to see the effects of their code changes immediately without manually restarting the application.
#### How it works: 
The application restarts only the context, keeping the JVM running. This makes the restart process much faster compared to a full restart.

### LiveReload:

#### Description: 
Integrates with LiveReload to automatically refresh the browser when resources are changed. This is useful for front-end development, allowing you to see changes in real-time without manually refreshing the browser.
#### How it works: 
Requires a LiveReload browser extension to be installed.

### Configurations for Development:

#### Description:
Provides sensible defaults for development, such as enabling certain logging settings, disabling caching for templates (Thymeleaf, Freemarker, etc.), and other optimizations that are beneficial during development but not in production.

### Global Settings:

#### Description: 
Allows for configuration of global settings that can be shared across multiple projects or developers.

#### How it works: 
Developers can place a file named spring-devtools.properties in the META-INF directory of their classpath, allowing shared settings.

### Remote Debugging:

#### Description: 
Supports remote debugging of an application running on a different machine. This is particularly useful when developing in an environment where the application cannot be run locally.
#### How it works: 
Developers can enable remote debugging through properties such as spring.devtools.remote.secret and use the remote client to connect.

### Additional Features:

#### Excludes spring-boot-devtools from shaded jars: 
By default, spring-boot-devtools will not be included in a fat jar (i.e., a jar with all dependencies) when the spring-boot-maven-plugin or spring-boot-gradle-plugin is used.
#### Disables restarting for certain paths: 
Certain directories (e.g., META-INF/resources, resources, static, public, and templates) are excluded from triggering a restart, as changes in these directories typically do not affect the application context.