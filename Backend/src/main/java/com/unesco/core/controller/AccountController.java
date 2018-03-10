package com.unesco.core.controller;

import com.unesco.core.models.additional.JSONResponseStatus;
import com.unesco.core.models.account.RoleModel;
import com.unesco.core.models.account.UserModel;
import com.unesco.core.entities.account.Role;
import com.unesco.core.repositories.account.RoleRepository;
import com.unesco.core.security.CustomUserDetailsService;
import com.unesco.core.services.dictionaryDataService.DitionaryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import com.unesco.core.entities.account.User;
import org.springframework.web.bind.annotation.*;
import com.unesco.core.repositories.account.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("api/account")
public class AccountController {

    @Autowired
    private CustomUserDetailsService _CustomUserDetailsService;
    @Autowired
    private UserRepository _UserRepository;
    @Autowired
    private RoleRepository _RoleRepository;
    @Autowired
    private DitionaryDataService ditionaryDataService;

    @GetMapping("/role")
    public List<RoleModel> GetLast() {
        return ditionaryDataService.getRoles();
    }

    @RequestMapping("/registration")
    public String Registration(@RequestBody User user) {
        if(user.getRoles().size() == 0){
            Set<Role> role = new HashSet<Role>();
            Role r = _RoleRepository.findByRole("USER");
            role.add(r);
            user.setRoles(role);
        } else {
            Set<Role> UserRoles = new HashSet<Role>();
            Role r = _RoleRepository.findByRole("USER");
            for(Role role : user.getRoles()){
                UserRoles.add(_RoleRepository.findByRole(role.getRoleName()));
            }
            user.setRoles(UserRoles);
        }
        _UserRepository.save(user);
        return JSONResponseStatus.OK;
    }

    @GetMapping("/user")
    public UserModel GetUser() {
        UserModel user = new UserModel(_CustomUserDetailsService.getUserDetails());
        return user;
    }

    @RequestMapping(value = "/FindUsersByName/{req}")
    public List<User> FindUsersByName(@PathVariable("req") String req) {
        Iterable<User> allUsers = _UserRepository.findAll();
        List<User> res = new ArrayList<User>();
        for (User item:allUsers) {
            if(item.getUsername().toLowerCase().contains(req.toLowerCase()))
            {
                res.add(item);
            }
        }
        return res;
    }
}