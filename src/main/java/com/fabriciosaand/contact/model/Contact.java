package com.fabriciosaand.contact.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact extends BaseEntity {

    private String name;
    private String description;
    private String number;

}
