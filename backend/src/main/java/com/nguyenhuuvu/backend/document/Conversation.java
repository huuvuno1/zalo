package com.nguyenhuuvu.backend.document;

import com.nguyenhuuvu.backend.domain.Base;
import com.nguyenhuuvu.backend.domain.Message;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document
public class Conversation extends Base {
    @Id
    private ObjectId _id;
    private List<String> members;
    private List<Message> messages;
}
