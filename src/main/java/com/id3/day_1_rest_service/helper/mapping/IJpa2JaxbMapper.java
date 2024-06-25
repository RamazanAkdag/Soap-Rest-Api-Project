package com.id3.day_1_rest_service.helper.mapping;

import com.id3.helloworldservice.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IJpa2JaxbMapper {
    /*
    * This interface is required to map package com.id3.helloworldservice.User and
    * package com.id3.day_1_rest_service.model.entity.User
    * */
    IJpa2JaxbMapper INSTANCE = Mappers.getMapper(IJpa2JaxbMapper.class);

    User jpa2JaxbUser(com.id3.day_1_rest_service.model.entity.User jpaUser);
    com.id3.day_1_rest_service.model.entity.User jaxb2jpaUser(User JaxbUser);


}
