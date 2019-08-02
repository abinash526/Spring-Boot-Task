package com.stackroute.springBoot;

import com.stackroute.springBoot.domain.Track;
import com.stackroute.springBoot.repository.TrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class EventHandling implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {
    @Value("${seedTrack1.id}")
    int id1;
    @Value("${seedTrack1.name}")
    String name1;
    @Value("${seedTrack1.comment}")
    String comment;
    @Value("${seedTrack2.id}")
    int id2;
    @Value("${seedTrack2.name}")
    String name2;
    @Value("${seedTrack2.comment}")
    String comment2;


    @Autowired
    private TrackRepository trackRepository;
    private static final Logger logger = LoggerFactory.getLogger(EventHandling.class);




    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        trackRepository.save(new Track(id1, name1, comment));
        trackRepository.findAll().forEach((track) -> {
            logger.info("{}", track);
        });


    }

    @Override
    public void run(String... args) throws Exception {
        int id;
        String name;
        String comment;
        trackRepository.save(new Track(id2, name2, comment2));

    }
}
