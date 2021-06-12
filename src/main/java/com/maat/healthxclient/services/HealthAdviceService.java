package com.maat.healthxclient.services;

import com.maat.healthxclient.model.HealthAdvice;
import com.maat.healthxclient.model.UserHealthData;
import com.maat.healthxclient.proxy.HealthSystemProxy;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.List.of;

@Service
public class HealthAdviceService {

  private final HealthSystemProxy healthSystemProxy;

  public HealthAdviceService(HealthSystemProxy healthSystemProxy) {
    this.healthSystemProxy = healthSystemProxy;
  }

  public void generateHealthAdvices(List<UserHealthData> userHealthData) {
    userHealthData.forEach(u -> {
      HealthAdvice advice = getMockHealthAdvice(u.getUsername());
      healthSystemProxy.sendAdvice(of(advice));
    });
  }

  private HealthAdvice getMockHealthAdvice(String username) {
    HealthAdvice advice = new HealthAdvice();
    advice.setUsername(username);
    advice.setAdvice("Mock advice for " + username);
    return advice;
  }
}
