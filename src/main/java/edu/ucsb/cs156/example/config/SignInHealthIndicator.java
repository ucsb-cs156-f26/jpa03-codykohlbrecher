package edu.ucsb.cs156.example.config;

import edu.ucsb.cs156.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class SignInHealthIndicator implements HealthIndicator {
  @Autowired
  private UserRepository userRepository;

  @Override
  public Health health() {
    if (userRepository.count() > 0) {
      return Health.up().build();
    }else{
      return Health.down().build();
    }
  }
}
