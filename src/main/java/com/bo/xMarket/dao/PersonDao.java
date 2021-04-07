package com.bo.xMarket.dao;

import com.bo.xMarket.model.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao {
    public void addPerson(Person person);

    public Integer getLastPersonId();

    Person getPersonById(Integer personId);
}
