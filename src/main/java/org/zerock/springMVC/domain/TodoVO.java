package org.zerock.springMVC.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoVO {
    private long tno;

    private String title;

    private LocalDate dueDate;

    private boolean finished;

    private String writer; // 새로 추가됨
}
