package com.Papi.kveldes.Demo_project.resource;

import com.Papi.kveldes.Demo_project.model.Employ;
import com.Papi.kveldes.Demo_project.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/employees")
public class EmployResource {

    private final EmployService employService;

    @Autowired
    public EmployResource(EmployService employService) {
        this.employService = employService;
    }


    @RequestMapping (
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List  <Employ> getAllEmployees(){
        return employService.getAllEmploys();


    }

    @RequestMapping (
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{employId}"

    )
    public Employ getEmployeeById(@PathVariable("employId") UUID employId){
        return employService.getEmployById(employId);


    }

    @RequestMapping (
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewEmploy (@RequestBody Employ employ){
        employService.persistNewEmploy(UUID.randomUUID(), employ);
    }
    @RequestMapping (
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{employId}"
    )
    public void updateEmploy (@PathVariable("employId") UUID employId ,@RequestBody Employ employ ){
        employService.updateEmployById(employId,employ);
    }

    @RequestMapping (
            method = RequestMethod.DELETE,
            path = "{employId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void deleteEmploy (@PathVariable("employId") UUID employId ){
        employService.deleteEmployById(employId);
    }

}
