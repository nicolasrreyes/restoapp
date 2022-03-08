package com.resto.restoapp.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.resto.restoapp.dto.UserRegisterDTO;
import com.resto.restoapp.entity.Rol;
import com.resto.restoapp.entity.User;
import com.resto.restoapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegisterDTO registerDTO) {
		User user = new User(registerDTO.getName(),
				registerDTO.getLastName(),
				registerDTO.getUser(),
				passwordEncoder.encode(registerDTO.getPassword()) ,
				Arrays.asList(new Rol("ROLE_USER")));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUser(username);
		if (user == null) {
			throw new UsernameNotFoundException("Usuario o password invalidos");
			}
			return new org.springframework.security.core.userdetails.User(user.getUser(), user.getPassword(), mapearAutoridadesRoles(user.getRoles()));
	}

		private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
			return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
		}
			
		

}
