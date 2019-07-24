package com.stackroute.springBoot;

import com.stackroute.springBoot.domain.Track;
import com.stackroute.springBoot.repository.TrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class EventHandling implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {
    @Autowired
    private TrackRepository trackRepository;
    private static final Logger logger = LoggerFactory.getLogger(EventHandling.class);




    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        trackRepository.save(new Track(1, "Senorita", "Good"));
        trackRepository.findAll().forEach((track) -> {
            logger.info("{}", track);
        });


    }

    @Override
    public void run(String... args) throws Exception {
        trackRepository.save(new Track(2, "Madhu", "good"));

    }
}
