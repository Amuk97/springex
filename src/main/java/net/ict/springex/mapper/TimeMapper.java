package net.ict.springex.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    @Select("select now()") //mapper 인터페이스
    String getTime();
}
