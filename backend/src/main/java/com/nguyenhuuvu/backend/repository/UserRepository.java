package com.nguyenhuuvu.backend.repository;

import com.nguyenhuuvu.backend.document.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findUserByEmail(String email);
}
