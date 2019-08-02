package com.stackroute.springBoot.repository;


import com.stackroute.springBoot.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer > {
   // public List<Track> findByName(String name);

}
