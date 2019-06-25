package br.com.stefanini.link.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.link.entity.Role;
import br.com.stefanini.link.entity.User;
import br.com.stefanini.link.repository.UserRepository;
import br.com.stefanini.link.service.UserService;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User update(User usuario) {
		Optional<User> user = userRepository.findById(usuario.getId());
		if (!user.isPresent()) {
			throw new RuntimeException("usuario não encontrado");
		} else {
//			Set<Role> roleDoUsuario = usuario.getRoles();
			User userAtualiza = userRepository.save(usuario);
			/*
			for (Role role : roleDoUsuario) {
				
			}
			*/
			return userAtualiza;
		}
	}
}
