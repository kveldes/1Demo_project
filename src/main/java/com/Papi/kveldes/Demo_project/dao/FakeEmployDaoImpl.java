package com.Papi.kveldes.Demo_project.dao;

import com.Papi.kveldes.Demo_project.model.Employ;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("FakeDao")
public class FakeEmployDaoImpl implements EmployDao{
    private final Map <UUID, Employ> database;

    public FakeEmployDaoImpl() {
        database = new HashMap<>();
        UUID employId = UUID.randomUUID();
        database.put(employId , new Employ(employId , 40, "Stephen" , "Hulk" ));
    }

    @Override
    public int insertNewEmploy(UUID employId, Employ employ) {
        database.put(employId, employ);
        return 1;
    }

    @Override
    public Employ selectEmployById(UUID employId) {
        return database.get(employId);
    }

    @Override
    public List<Employ> selectAllEmploys() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateEmployById(UUID employId, Employ employUpdate) {
        database.put(employId, employUpdate);
        return 1;
    }

    @Override
    public int deleteEmployById(UUID employId) {
        database.remove(employId);
        return 1;
    }
}
