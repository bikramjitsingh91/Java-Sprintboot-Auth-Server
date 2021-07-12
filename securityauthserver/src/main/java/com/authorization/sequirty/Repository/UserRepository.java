package com.authorization.sequirty.Repository;

import com.authorization.sequirty.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
//    List<User> findByLastName(String lastName);
//
//    User findById(long id);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findUserByUserName(@Param("username") String username);
}
