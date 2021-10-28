package com.nguyenhuuvu.backend.domain;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@Builder
@Document
public class Conversation extends Base{
    @Id
    private ObjectId _id;
    private List<String> members;
}
