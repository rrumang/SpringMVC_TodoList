package org.zerock.springMVC.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private long tno;

    @NotEmpty
    private String title;

    private LocalDate dueDate;

    private boolean finished;

    @NotEmpty
    private String writer;
}
