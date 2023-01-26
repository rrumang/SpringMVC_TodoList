package org.zerock.springMVC.service;

import org.zerock.springMVC.dto.PageRequestDTO;
import org.zerock.springMVC.dto.PageResponseDTO;
import org.zerock.springMVC.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void register(TodoDTO todoDTO);

    // List<TodoDTO> getAll();
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void remove(long tno);

    void modify(TodoDTO todoDTO);
}
