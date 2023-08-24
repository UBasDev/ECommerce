package org.ucbdev.ecommerceapi.infrastructure.persistence.service;

import org.springframework.stereotype.Service;
import org.ucbdev.ecommerceapi.core.application.service.IUserService;

@Service
public class UserService implements IUserService {
    @Override
    public void createSingleUser() {
System.nanoTime();
        System.out.println("User has been created");
    }
}
