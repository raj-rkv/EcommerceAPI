package com.example.ecommerce.service;

import com.example.ecommerce.dao.AddressRepository;
import com.example.ecommerce.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService{
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public int addAddress(Address addressData) {
        Address address=addressRepository.save(addressData);
        return address.getAddressId();
    }

}
