package VetHome.com.veterinaria.convert;


import VetHome.com.veterinaria.DTO.CustomerDTO;
import VetHome.com.veterinaria.entity.Customer;
import VetHome.com.veterinaria.entity.Pet;
import VetHome.com.veterinaria.service.VetService;

import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class UtilityService {

    @Autowired
    private ModelMapper modelMapper;

    private final VetService vetService;


    public CustomerDTO convertCustomerToCustomerDTO(Customer customer){

        return modelMapper.map(customer, CustomerDTO.class);
    }

    public Customer convertCustomerDTOtoCustomerCreate(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setLastName(customerDTO.getLastName());
        customer.setPets(customerDTO.getPets());
        customer.setPassword(customerDTO.getPassword());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setContactNumber(customerDTO.getContactNumber());
        return customer;
    }



    public Customer convertCustomerDTOtoCustomerUpdate(CustomerDTO customerDTO, Customer existingCustomer) {
        if (StringUtils.isNotBlank(customerDTO.getName())) {
            existingCustomer.setName(customerDTO.getName());
        }
        if (StringUtils.isNotBlank(customerDTO.getLastName())) {
            existingCustomer.setLastName(customerDTO.getLastName());
        }
        if (StringUtils.isNotBlank(customerDTO.getAddress())) {
            existingCustomer.setAddress(customerDTO.getAddress());
        }
        if (StringUtils.isNotBlank(customerDTO.getEmail())) {
            existingCustomer.setEmail(customerDTO.getEmail());
        }
        if (StringUtils.isNotBlank(customerDTO.getContactNumber())) {
            existingCustomer.setContactNumber(customerDTO.getContactNumber());
        }
        if (StringUtils.isNotBlank(customerDTO.getPassword())) {
            existingCustomer.setPassword(customerDTO.getPassword());
        }
        return existingCustomer;
    }

    public Customer convertCustomerDTOtoCustomerUpdate1(CustomerDTO customerDTO, Customer existingCustomer) {
        existingCustomer.setName(customerDTO.getName());
        existingCustomer.setLastName(customerDTO.getLastName());
        existingCustomer.setAddress(customerDTO.getAddress());
        existingCustomer.setEmail(customerDTO.getEmail());
        existingCustomer.setContactNumber(customerDTO.getContactNumber());
        existingCustomer.setPassword(customerDTO.getPassword());
        return existingCustomer;
    }


    public void createPet(Customer customer, Pet pet){
        Pet newPet = new Pet();
        newPet.setPetName(pet.getPetName());
        newPet.setAge(pet.getAge());
        newPet.setGender(pet.getGender());
        newPet.setPetSpecies(pet.getPetSpecies());
        customer.getPets().add(newPet);
    }

    public void updatePetProperties(Pet existingPet, Pet pet) {
        modelMapper.map(pet, existingPet);
    }



}
