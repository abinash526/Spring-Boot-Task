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
   
    TrackService trackService;
    
    @Autowired
    public UserController(TrackService trackService) {
        this.trackService = trackService;
    }
    @PostMapping("/track")
    public ResponseEntity<?> saveuser(@RequestBody Track track)throws RuntimeException{

        ResponseEntity responseEntity;

            trackService.saveUser(track);
            responseEntity=new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);


        return responseEntity;
    }
    @PostMapping("/tracks")
    public ResponseEntity<?> saveuser1(@RequestBody List<Track> track)throws RuntimeException{

        ResponseEntity responseEntity;
        for (Track t:track
             ) {
            trackService.saveUser(t);
        }

        responseEntity=new ResponseEntity<List<Track>>(trackService.getAllUsers(), HttpStatus.CREATED);


        return responseEntity;
    }
    @GetMapping("user")
    public ResponseEntity<?> getAllUsers(){
        //System.out.println(trackRepository.findByFirstName("Abinash"));


      //  System.out.println(trackService.getByTrackName(name).toString());

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
    @RequestMapping("/*")
    public String klm()throws RuntimeException{
        if(true)
        throw new RuntimeException("Page not found");
        return null;
    }

}
