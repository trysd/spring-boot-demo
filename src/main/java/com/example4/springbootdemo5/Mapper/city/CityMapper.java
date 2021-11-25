package com.example4.springbootdemo5.Mapper.city;

import com.example4.springbootdemo5.entity.city.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {
  @Select("SELECT id, name, state, country FROM city WHERE state = #{state}")
  City findByState(@Param("state") String state);
}
