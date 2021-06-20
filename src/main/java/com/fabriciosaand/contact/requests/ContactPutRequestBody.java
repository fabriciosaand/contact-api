package com.fabriciosaand.contact.requests;

import lombok.Data;

@Data
public class ContactPutRequestBody {
    private Long id;
    private String name;
    private String description;
    private String number;
}
