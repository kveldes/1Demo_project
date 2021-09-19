package com.Papi.kveldes.Demo_project.service;

import com.Papi.kveldes.Demo_project.dao.EmployDao;
import com.Papi.kveldes.Demo_project.model.Employ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployService {

    private final EmployDao employDao;

    @Autowired
    public EmployService(@Qualifier("FakeDao") EmployDao employDao) {
        this.employDao = employDao;
    }

    public int persistNewEmploy (UUID employId, Employ employ){
        UUID employUid = employId == null ? UUID.randomUUID() : employId;
        employ.setId(employId);
        return employDao.insertNewEmploy(employId , employ);

   }

   public Employ getEmployById(UUID employId){
        return employDao.selectEmployById(employId);
   }

   public List<Employ> getAllEmploys(){
        return employDao.selectAllEmploys();

   }

   public int updateEmployById(UUID employId, Employ employUpdate){
        return employDao.updateEmployById(employId , employUpdate);

   }

   public int deleteEmployById(UUID employId){
        return employDao.deleteEmployById(employId);

   }

}
