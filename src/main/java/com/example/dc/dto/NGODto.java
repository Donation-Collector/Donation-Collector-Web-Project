package com.example.dc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NGODto {
    private String name;
    private String phoneNum;
    private String email;
    private String description;
    private int distance;
}
