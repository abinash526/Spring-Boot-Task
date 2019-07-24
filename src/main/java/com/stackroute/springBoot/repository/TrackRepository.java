package com.stackroute.springBoot.repository;


import com.stackroute.springBoot.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer > {
    public List<Track> findByName(String name);



    @Query("from Track where name=?1 order by id")
    List<Track> findByNameSortedById(String name);

}
