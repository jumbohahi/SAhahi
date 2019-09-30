package com.okta.springbootvue;



import com.okta.springbootvue.Entity.*;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

/**
 * IDs are not returned by RestRepository by default. I like them exposed so that the client can easily find
 * the ID of created and listed resources.
 * */
@Component
public class RestRepositoryConfigurator implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
   

    config.exposeIdsFor(Personnel.class);
    config.exposeIdsFor(Position.class);
    config.exposeIdsFor(Department.class);
    // config.exposeIdsFor(Role.class);
    config.exposeIdsFor(Prefix.class);

  }
}