package com.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewTaskDTO {

    private String name;

    private String description;

    private String expirationDate;

    private String columnLink;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //TODO: some strange things in DB. Date - 1
    @SneakyThrows
    public Date getExpirationDate() {
        if (expirationDate != null) {
            return dateFormat.parse(expirationDate);
        }
        return new Date();
    }
}
