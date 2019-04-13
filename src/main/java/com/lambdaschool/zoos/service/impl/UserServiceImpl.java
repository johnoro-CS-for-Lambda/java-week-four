package com.lambdaschool.zoos.service.impl;

import com.lambdaschool.zoos.models.User;
import com.lambdaschool.zoos.repositories.UserRepository;
import com.lambdaschool.zoos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
  @Autowired
  private UserRepository userRepository;

  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    User user = userRepository.findByName(name);
    if (user == null) {
      throw new UsernameNotFoundException("Invalid username or password.");
    }
    return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), user.getAuthority());
  }

  public List<User> findAll() {
    List<User> list = new ArrayList<>();
    userRepository.findAll().iterator().forEachRemaining(list::add);
    return list;
  }

  @Override
  public void delete(long id) {
    userRepository.deleteById(id);
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }
}
