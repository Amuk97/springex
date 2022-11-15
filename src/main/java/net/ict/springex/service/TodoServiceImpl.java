package net.ict.springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.domain.TodoVO;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//데이터 베이스를 처리하는 TodoMapper와 DTO 변환을 처리하는 ModelMapper 주입
@Service
@Log4j2
//의존성 주입이 필요한 객체의 타입을 final로 고정하고 생성자 @RequiredArgsConstructor 를 이용하여 생성하는 방식 사용
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO){
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO,TodoVO.class);
        log.info(todoVO);
        todoMapper.insert(todoVO);

    }

    @Override
    public List<TodoDTO> getAll() {
        List<TodoDTO> dtoList =todoMapper.selectAll().stream()
                //vo 는 modelMapper를 통해 TodoDTO로 바뀜
                .map(vo->modelMapper.map(vo , TodoDTO.class))
                //패키징 작업
                .collect(Collectors.toList());
        return dtoList;
        //List<TodoVO>를 Lsit<TodoDTO>로 변환하는 작업을 stram을 이용하며
        //각 TodoVO는 map()을 통해서 TodoDTO로 바꾸고 collect()를 이용하여 List<TodoDTO>로 묶어준다
    }
}
