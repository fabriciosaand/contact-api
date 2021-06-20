package com.fabriciosaand.contact.requests;

import lombok.Data;

@Data
public class ContactPostRequestBody {
    private String name;
    private String description;
    private String number;
}
