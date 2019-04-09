package com.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewTaskDTO {

    private String name;

    private String description;

    private Date expirationDate;

    private Long columnId;
}
