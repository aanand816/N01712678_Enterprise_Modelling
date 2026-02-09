package com.example.springbootwebflux_assign2_aanand.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "members")
public class Member {

    @Id
    private String membId;
    private String name;
    private String address;
    private String membType;
    private String membDate;
    private String expiryDate;
}
