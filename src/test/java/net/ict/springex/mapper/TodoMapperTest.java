package net.ict.springex.mapper;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.domain.TodoVO;
import org.apache.ibatis.annotations.Insert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {
    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Autowired(required = false)
    private TimeMapper2 timeMapper2;
    @Test
    public void testNow(){
        log.info(timeMapper2.getNow());
    }

    @Test
    public void testInsert(){
        TodoVO todoVO =TodoVO.builder()
                .title("SpringTest")
                .dueDate(LocalDate.of(2022,11,14))
                .writer("ict05")
                .build();

        todoMapper.insert(todoVO);
    }
    @Test
    public void testSelectAll(){
        List<TodoVO> voList =todoMapper.selectAll();
        voList.forEach(vo->log.info(vo));
    }


}
