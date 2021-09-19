package com.Papi.kveldes.Demo_project.dao;

import com.Papi.kveldes.Demo_project.model.Employ;

import java.util.List;
import java.util.UUID;

public interface EmployDao {

    int insertNewEmploy (UUID employId, Employ employ);

    Employ selectEmployById(UUID employId);

    List <Employ> selectAllEmploys();

    int updateEmployById(UUID employId, Employ employUpdate);

    int deleteEmployById(UUID employId);
}
