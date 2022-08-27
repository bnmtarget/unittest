package bnm.bnmapi;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableAutoConfiguration
@Repository
public interface UserRepository extends JpaRepository<Userdetails,String> {
    Optional<Userdetails> findByEmailId(String emailId);

    Optional<Userdetails> findByEmailIdAndPassword(String emailId,String password);


    Optional<Userdetails> findByUserId(Integer userId);
}