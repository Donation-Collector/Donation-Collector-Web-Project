package com.example.dc.dto;

import com.example.dc.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DropOffDto {
    private String name;
    private String phoneNum;
    private String email;
    private Address address;
    private int distance;
}
