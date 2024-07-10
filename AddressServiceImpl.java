package com.wakefit.ecommerce.serviceimplement;

import com.wakefit.ecommerce.entity.Address;
import com.wakefit.ecommerce.exception.ResourceNotFoundException;
import com.wakefit.ecommerce.repository.AddressRepository;
import com.wakefit.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Long addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id " + addressId));
    }

    @Override
    public Address updateAddress(Long addressId, Address updatedAddress) {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        
        if (optionalAddress.isPresent()) {
            Address existingAddress = optionalAddress.get();
            
            // Update attributes based on updatedAddress object
            existingAddress.setLandmark(updatedAddress.getLandmark());
            existingAddress.setAddress(updatedAddress.getAddress());
            existingAddress.setCity(updatedAddress.getCity());
            existingAddress.setState(updatedAddress.getState());
            existingAddress.setPincode(updatedAddress.getPincode());
            
            // Return the updated address
            return addressRepository.save(existingAddress);
        } else {
            throw new ResourceNotFoundException("Address not found with id " + addressId);
        }
    }

    @Override
    public void deleteAddress(Long addressId) {
        if (!addressRepository.existsById(addressId)) {
            throw new ResourceNotFoundException("Address not found with id " + addressId);
        }
        addressRepository.deleteById(addressId);
    }
}
