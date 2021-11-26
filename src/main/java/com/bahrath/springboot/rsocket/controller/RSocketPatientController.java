package com.bahrath.springboot.rsocket.controller;

import com.bahrath.springboot.rsocket.model.Claim;
import com.bahrath.springboot.rsocket.model.ClinicalPatientData;
import com.bahrath.springboot.rsocket.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller
public class RSocketPatientController {

    Logger logger = LoggerFactory.getLogger(RSocketPatientController.class);

    @MessageMapping("get-patient-data")
    public Mono<ClinicalPatientData> requestResponse(@RequestBody Patient patient) {
        logger.info("Received Patient: "+patient);
        return Mono.just(new ClinicalPatientData(90, "80/120"));
    }

    @MessageMapping("patient-checkout")
    public Mono<Void> fireAndForget(@RequestBody Patient patient) {
        logger.info("Patient Checking out: "+patient);
        logger.info("Billing Initiated");
        return Mono.empty().then();
    }

    @MessageMapping("claim-stream")
    public Flux<Claim> requestStream() {
        return Flux.just(new Claim(1000f, "MRI Scan"),
                new Claim(2000f, "Surgery"),
                new Claim(500f, "Food")).delayElements(Duration.ofSeconds(2));
    }

}
