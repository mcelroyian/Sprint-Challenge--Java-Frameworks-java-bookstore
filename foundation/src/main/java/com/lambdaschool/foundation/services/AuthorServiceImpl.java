package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.*;
import com.lambdaschool.foundation.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        List<Author> list = new ArrayList<>();
        authorRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Author save(Author author) {
        User newUser = new User();

//        if (user.getUserid() != 0)
//        {
//            User oldUser = userrepos.findById(user.getUserid())
//                    .orElseThrow(() -> new ResourceNotFoundException("User id " + user.getUserid() + " not found!"));
//
//            // delete the roles for the old user we are replacing
//            for (UserRoles ur : oldUser.getRoles())
//            {
//                deleteUserRole(ur.getUser()
//                                .getUserid(),
//                        ur.getRole()
//                                .getRoleid());
//            }
//            newUser.setUserid(user.getUserid());
//        }
//
//        newUser.setUsername(user.getUsername()
//                .toLowerCase());
//        newUser.setPasswordNoEncrypt(user.getPassword());
//        newUser.setPrimaryemail(user.getPrimaryemail()
//                .toLowerCase());
//
//        newUser.getRoles()
//                .clear();
//        if (user.getUserid() == 0)
//        {
//            for (UserRoles ur : user.getRoles())
//            {
//                Role newRole = roleService.findRoleById(ur.getRole()
//                        .getRoleid());
//
//                newUser.addRole(newRole);
//            }
//        } else
//        {
//            // add the new roles for the user we are replacing
//            for (UserRoles ur : user.getRoles())
//            {
//                addUserRole(newUser.getUserid(),
//                        ur.getRole()
//                                .getRoleid());
//            }
//        }
//
//        newUser.getUseremails()
//                .clear();
//        for (Useremail ue : user.getUseremails())
//        {
//            newUser.getUseremails()
//                    .add(new Useremail(newUser,
//                            ue.getUseremail()));
//        }

        return authorRepository.save(author);
    }
}
