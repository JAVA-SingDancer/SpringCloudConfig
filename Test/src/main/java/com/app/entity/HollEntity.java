package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@ToString
public class HollEntity {
    private int id;
    private String type;
    private String startTime;
    private String endTime;
}
