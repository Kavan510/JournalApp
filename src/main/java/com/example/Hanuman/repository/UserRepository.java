package com.example.Hanuman.repository;

import com.example.Hanuman.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String userName);
void deleteByUserName(String userName);
}
