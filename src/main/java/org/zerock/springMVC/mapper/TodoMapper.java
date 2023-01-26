package org.zerock.springMVC.mapper;

import org.zerock.springMVC.domain.TodoVO;
import org.zerock.springMVC.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO vo);

    List<TodoVO> selectAll();

    TodoVO selectOne(long tno);

    void delete(long tno);

    void update(TodoVO vo);

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);
}
