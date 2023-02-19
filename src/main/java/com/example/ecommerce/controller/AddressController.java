package com.example.ecommerce.controller;

import com.example.ecommerce.dao.UserRepository;
import com.example.ecommerce.model.Address;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.IAddressService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ecommerce-app")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/address")
    public ResponseEntity createAddress(@RequestBody String addressData)
    {
        JSONObject json=new JSONObject(addressData);
        Address address=setAddress(json);
        int addressId=addressService.addAddress(address);
        return new ResponseEntity<>("Address created with id- "+addressId, HttpStatus.CREATED);
    }

    private Address setAddress(JSONObject json){
        Address address= new Address();
        address.setAddressName(json.getString("addressName"));
        address.setLandmark(json.getString("landmark"));
        address.setPhoneNumber(json.getString("phoneNumber"));
        address.setState(json.getString("state"));
        address.setZipcode(json.getString("zipcode"));

        Integer userId=json.getInt("user");
        User user=userRepository.findById(userId).get();
        address.setUser(user);

        return address;
    }


}
