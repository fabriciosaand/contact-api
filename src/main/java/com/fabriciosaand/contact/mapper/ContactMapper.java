package com.fabriciosaand.contact.mapper;

import com.fabriciosaand.contact.dto.request.ContactDTO;
import com.fabriciosaand.contact.model.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    ContactDTO contactToContactDTO(Contact entity);

    Contact contactDTOtoContact(ContactDTO contactDTO);

}
