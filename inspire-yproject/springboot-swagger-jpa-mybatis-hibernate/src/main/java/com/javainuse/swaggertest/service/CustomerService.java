package com.javainuse.swaggertest.service;

import java.util.List;

import javax.transaction.Transactional;


import com.javainuse.swaggertest.dao.CustomerDao;
import com.javainuse.swaggertest.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("customerService")
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Transactional
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Transactional
    public Customer getCustomer(int id) {
        return customerDao.getCustomer(id);
    }

    @Transactional
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Transactional
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);

    }

    @Transactional
    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }
}