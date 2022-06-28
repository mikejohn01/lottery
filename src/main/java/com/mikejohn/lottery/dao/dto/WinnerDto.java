package com.mikejohn.lottery.dao.dto;

import lombok.Data;

@Data
public class WinnerDto {
    private String name;
    private int age;
    private String city;
    private int amount;
}
