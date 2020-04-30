package com.example.dc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class DonationRequestWithItem {
    private Long id;
    private Address address;
    private String email;

    private String notes;
    private String status;
    private Date date;
    private NGO ngo;
    private List<ItemSimple> items;
}
