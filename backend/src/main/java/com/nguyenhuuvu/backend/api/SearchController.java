package com.nguyenhuuvu.backend.api;

import com.nguyenhuuvu.backend.dto.BaseResponse;
import com.nguyenhuuvu.backend.dto.SearchQuery;
import com.nguyenhuuvu.backend.dto.UserDTO;
import com.nguyenhuuvu.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
public class SearchController {
    final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> fetchUsers(@RequestBody SearchQuery<String> query) {
        List<UserDTO> users =  userService.find(query);
        return new ResponseEntity<>(new BaseResponse<UserDTO>().builder()
                .timeStamp(new Date())
                .message("Ok")
                .status(HttpStatus.OK.value())
                .data(users)
            .build(),
        HttpStatus.OK);
    }
}
