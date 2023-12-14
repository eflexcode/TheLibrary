package com.larrex.thelibrary.auth.serviceImpl;

import com.larrex.thelibrary.liberian.service.LiberianService;
import com.larrex.thelibrary.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserServiceImpl implements UserDetailsService {

    private final LiberianService liberianService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return liberianService.getLiberianByEmail(username);
    }
}
