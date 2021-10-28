package com.nguyenhuuvu.backend.domain;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Builder
@Document
public class User extends Base{
    @Id
    private ObjectId _id;
    private String fullName;
    private String gender;
    private String address;
    private String email;
    private String password;
    private String avatar;
}
