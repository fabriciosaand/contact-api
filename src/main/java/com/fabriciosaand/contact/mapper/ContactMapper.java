package com.fabriciosaand.contact.mapper;

import com.fabriciosaand.contact.model.Contact;
import com.fabriciosaand.contact.requests.ContactPostRequestBody;
import com.fabriciosaand.contact.requests.ContactPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ContactMapper {
    public static final ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    public abstract Contact toContact(ContactPostRequestBody contactPostRequestBody);

    public abstract Contact toContact(ContactPutRequestBody contactPutRequestBody);

}
