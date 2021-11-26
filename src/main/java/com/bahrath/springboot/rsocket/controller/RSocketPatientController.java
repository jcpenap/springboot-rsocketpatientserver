package com.bahrath.springboot.rsocket.controller;

import com.bahrath.springboot.rsocket.model.ClinicalPatientData;
import com.bahrath.springboot.rsocket.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@Controller
public class RSocketPatientController {

    Logger logger = LoggerFactory.getLogger(RSocketPatientController.class);

    @MessageMapping("get-patient-data")
    public Mono<ClinicalPatientData> requestResponse(@RequestBody Patient patient) {
        logger.info("Received Patient: "+patient);
        return Mono.just(new ClinicalPatientData(90, "80/120"));
    }

}
