package edu.ucsb.cs156.example.testconfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import edu.ucsb.cs156.example.config.SignInHealthIndicator;
import edu.ucsb.cs156.example.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;

public class SignInHealthIndicatorTests {
  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private SignInHealthIndicator signInHealthIndicator;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void returns_up_when_user_exists() {
    when(userRepository.count()).thenReturn(1L);
    Health health = signInHealthIndicator.health();
    assertEquals(Status.UP, health.getStatus());
  }

  @Test
  public void returns_down_when_user_does_not_exist() {
    when(userRepository.count()).thenReturn(0L);
    Health health = signInHealthIndicator.health();
    assertEquals(Status.DOWN, health.getStatus());
  }

}
