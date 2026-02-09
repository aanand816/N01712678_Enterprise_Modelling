package com.example.springbootwebflux_assign2_aanand.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "books")
public class Book {

    @Id
    private String bookId;

    private String title;
    private String author;
    private Double price;
    private Boolean available;
    private String publisherId;
    private String memberId;
    private String issue;
    private String dueDate;
    private String returnDate;
}
