package net.ict.springex.service;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoserviceTest {
    @Autowired
    private TodoService todoService;
    @Test
    public void testRegister(){
        TodoDTO todoDTO = TodoDTO.builder()
                .title("test title")
                .dueDate(LocalDate.of(2022,11,14))
                .writer("test writer")
                .build();
        todoService.register(todoDTO);
    }
}
