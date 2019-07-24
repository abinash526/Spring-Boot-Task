package com.stackroute.springBoot.service;

import com.stackroute.springBoot.domain.Track;

import java.util.List;

public interface TrackService {
    public Track saveUser(Track track);
    public List<Track> getAllUsers();
    public boolean updateUser(Track track, int id);

    public void deleteUser(int id);
}
