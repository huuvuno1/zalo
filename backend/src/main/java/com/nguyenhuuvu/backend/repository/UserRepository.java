package com.nguyenhuuvu.backend.repository;

import com.nguyenhuuvu.backend.document.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findFirstByEmail(String email);
    List<User> findUsersByEmail(String email);
    List<User> findUsersByEmailOrFullNameContains(String email, String fullName);
}
