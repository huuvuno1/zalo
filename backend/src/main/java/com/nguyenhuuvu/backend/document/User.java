package com.nguyenhuuvu.backend.document;

import com.nguyenhuuvu.backend.domain.Base;
import com.nguyenhuuvu.backend.utils.Constant;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
@Builder
@Document
public class User extends Base {
    @Id
    private ObjectId _id;

    @NotBlank(message = Constant.NOT_BLANK)
    @Length(min = 5, max = 30, message = Constant.LENGTH_NOT_ALLOWED)
    private String fullName;
    private String gender;
    private String address;
    @NotBlank(message = Constant.NOT_BLANK)
    private String email;
    @NotBlank(message = Constant.NOT_BLANK)
    @Length(min = 5, message = Constant.LENGTH_NOT_ALLOWED)
    private String password;
    private String avatar;
    private List<String> roles;
    private boolean enable;
    private VerifyInfo verifyInfo;
}
