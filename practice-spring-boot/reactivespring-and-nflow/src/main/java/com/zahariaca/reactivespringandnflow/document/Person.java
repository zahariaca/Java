package com.zahariaca.reactivespringandnflow.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
}
