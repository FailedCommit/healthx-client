package com.maat.healthxclient.controllers;

import com.maat.healthxclient.model.UserHealthData;
import com.maat.healthxclient.services.HealthAdviceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthAdviceController {

  private final HealthAdviceService adviceService;

  public HealthAdviceController(HealthAdviceService adviceService) {
    this.adviceService = adviceService;
  }

  @PostMapping("/data")
  public void collectHealthDataForAdvice(
          @RequestBody List<UserHealthData> userHealthData) {
    adviceService.generateHealthAdvices(userHealthData);
  }
}
