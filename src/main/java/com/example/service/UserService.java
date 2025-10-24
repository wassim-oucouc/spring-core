package com.example.service;

import com.example.entity.Users;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService{



    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<Users> getAll() {
        return userRepository.findAll();
    }

    public Optional<Users> findUserById(long id)
    {
        return this.userRepository.findById(id);
    }

    public Page<Users> getUsersPageable(int page,int size,String sortBy,Boolean asc)
    {
            Sort sort = asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page,size,sort);

       return this.userRepository.findAll(pageable);
    }

    public Users createUser(Users users)
    {
        return this.userRepository.save(users);
    }

    public Optional<Users> updateUserById(long id,Users userDetails)
    {
       return this.userRepository.findById(id).map(userUpdate -> {
            userUpdate.setName(userDetails.getName());
            userUpdate.setEmail(userDetails.getEmail());
            if(userUpdate.getPassword() != null && !userUpdate.getPassword().isEmpty()) {
                userUpdate.setPassword(userDetails.getPassword());
            }
            userUpdate.setRole(userDetails.getRole());
            userUpdate.setActive(userDetails.getActive());
            userUpdate.setCreatedAt(userDetails.getCreatedAt());

              return this.userRepository.save(userUpdate);
        });


    }
    public Boolean DeleteUserByID(long id)
    {
        if(userRepository.existsById(id))
        {
            this.userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
