package com.stackroute.springBoot.service;

import com.stackroute.springBoot.domain.Track;
import com.stackroute.springBoot.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveUser(Track track) {
        Track saveTrack = (Track) trackRepository.save(track);
        return saveTrack;
    }

    @Override
    public List<Track> getAllUsers() {
        return trackRepository.findAll();
    }
    @Override
    public boolean updateUser(Track track, int id)
    {
       // Optional<Track> optionalUser=trackRepository.findById(id);
        if(!trackRepository.findById(id).isPresent())
            return false;

        track.setId(id);
        trackRepository.save(track);
        return  true;

    }
    @Override
    public void deleteUser(int id)
    {
        trackRepository.deleteById(id);
    }
    @Override
    public List<Track> getByTrackName(String name){
        return trackRepository.findByName(name);
    }
    @Override
    public List<Track> getTrackByNameSortByName(String name)
    {
        return trackRepository.findByNameSortedById(name);
    }
        }



