package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.*;
import com.lambdaschool.foundation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "bookService")
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        bookRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id) {
        bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book id " + id + " not found!"));
        bookRepository.deleteById(id);
    }

    @Override
    public Book save(Book book) {
//        User newUser = new User();
//
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

        return bookRepository.save(book);
    }
}
