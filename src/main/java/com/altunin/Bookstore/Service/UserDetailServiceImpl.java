package com.altunin.Bookstore.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.altunin.Bookstore.domain.User;
import com.altunin.Bookstore.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository urepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> currUser = urepository.findByUsername(username);
		
		UserDetails user  =  new org.springframework.security.core.userdetails.User(username, currUser.get().getPassword(), true, true,  true, true, AuthorityUtils.createAuthorityList(currUser.get().getRole()));
		
		return user;
	}
}
