package com.stackroute.springBoot.controller;

import com.stackroute.springBoot.domain.Track;
import com.stackroute.springBoot.exception.TrackNotFoundException;
import com.stackroute.springBoot.repository.TrackRepository;
import com.stackroute.springBoot.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="api/v1")
public class UserController {
    @Value("${track.name}")
    String name;
    @Autowired
    TrackService trackService;
    TrackRepository trackRepository;

    public UserController(TrackService trackService) {
        this.trackService = trackService;
    }
    @PostMapping("track")
    public ResponseEntity<?> saveuser(@RequestBody Track track)throws RuntimeException{

        ResponseEntity responseEntity;

            trackService.saveUser(track);
            responseEntity=new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);


        return responseEntity;
    }
    @GetMapping("user")
    public ResponseEntity<?> getAllUsers(){
        //System.out.println(trackRepository.findByFirstName("Abinash"));


        System.out.println(trackService.getByTrackName(name).toString());
        System.out.println(trackService.getTrackByNameSortByName(name).toString());

        return new ResponseEntity<List<Track>>(trackService.getAllUsers(),HttpStatus.OK);
    }
    @PutMapping(value = "/update")
    public ResponseEntity<?> updateUser(@RequestBody Track track)
    {
        ResponseEntity responseEntity;

            trackService.saveUser(track);
            responseEntity=new ResponseEntity<String>("Succesfully Updated",HttpStatus.CREATED);


        return responseEntity;
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) throws RuntimeException
    {
        ResponseEntity responseEntity;

            trackService.deleteUser(id);
        responseEntity=new ResponseEntity<String>("Succesfully deleted",HttpStatus.NO_CONTENT);
        return responseEntity;

    }

}
