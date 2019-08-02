package com.stackroute.springBoot.service;

import com.stackroute.springBoot.domain.Track;
import com.stackroute.springBoot.exception.TrackAlreadyExistException;
import com.stackroute.springBoot.exception.TrackNotFoundException;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrackService {
    public Track saveUser(Track track) throws RuntimeException;
    public List<Track> getAllUsers();
    public boolean updateUser(Track track, int id);
    public void deleteUser(int id) throws RuntimeException;
    List<Track> getByTrackName(String name);
    List<Track> getTrackByNameSortByName(String name);
}
