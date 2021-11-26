package com.bahrath.springboot.rsocket.controller;

import com.bahrath.springboot.rsocket.model.ClinicalPatientData;
import com.bahrath.springboot.rsocket.model.Patient;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class RSocketPatientController {

    @MessageMapping("get-patient-data")
    public Mono<ClinicalPatientData> requestResponse(Patient patient) {
        return Mono.just(new ClinicalPatientData(90, "80/120"));
    }

}
