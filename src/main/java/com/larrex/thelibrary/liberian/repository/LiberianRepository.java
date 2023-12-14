package com.larrex.thelibrary.liberian.repository;

import com.larrex.thelibrary.auth.entity.VerificationToken;
import com.larrex.thelibrary.liberian.entity.Liberian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LiberianRepository extends JpaRepository<Liberian,Long> {
    Optional<Liberian> findByEmail(String email);

}
