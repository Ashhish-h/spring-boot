## @Configuration annotation

The @Configuration annotation in Spring is one of the most important annotations. It indicates that a class contains @Bean definition methods, which the Spring container can process to generate Spring Beans for use in the application. This annotation is part of the Spring Core framework.

## EnableWebSecurity annotation

@EnableWebSecurity is used for spring security java configuration. Add this annotation with @configuration on top of your security java class that extends WebSecurityConfigurerAdapter.

Override the configure(WebSecurity web) & configure(HttpSecurity http). This is the replacement of xml based configurations like <http> and <form login>. This way you can limit requested urls coming from specific urls also enable form based log in.