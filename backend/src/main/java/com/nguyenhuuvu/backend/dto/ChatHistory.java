package com.nguyenhuuvu.backend.dto;

import com.nguyenhuuvu.backend.domain.Message;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatHistory {
    private String avatar;
    private String sender;
    private Message message;
}
