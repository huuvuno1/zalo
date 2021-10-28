package com.nguyenhuuvu.backend.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Message extends Base{
    private String sender;
    private String message;
}
