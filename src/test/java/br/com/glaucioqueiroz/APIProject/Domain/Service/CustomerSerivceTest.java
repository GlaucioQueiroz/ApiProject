package br.com.glaucioqueiroz.APIProject.Domain.Service;

import br.com.glaucioqueiroz.APIProject.DataModel.CustomerModel;
import br.com.glaucioqueiroz.APIProject.Domain.Interface.ICustomerRepository;
import br.com.glaucioqueiroz.APIProject.ViewModel.CustomerViewModel;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerSerivceTest {

    private CustomerSerivce customerSerivce;

    private ICustomerRepository repository;
    @BeforeEach
    void setUp() {
        repository = mock(ICustomerRepository.class);
        customerSerivce = new CustomerSerivce(repository);
    }

    @Test
    void EditNotFound() {
        when(repository.findById(any())).thenReturn(Optional.of(new CustomerModel()));
        Exception exception = assertThrows(NotFoundException.class, () -> {
            customerSerivce.Edit(new CustomerViewModel(){},1);
        });
    }

    @Test
    void DeleteNotFound() {
        when(repository.findById(any())).thenReturn(Optional.of(new CustomerModel()));
        Exception exception = assertThrows(NotFoundException.class, () -> {
            customerSerivce.Delete(1);
        });
    }

    @Test
    void DeleteFound() throws NotFoundException {
        when(repository.findById(any())).thenReturn(GetCustomer(1));
        customerSerivce.Delete(1);
    }

    private Optional<CustomerModel> GetCustomer(int id) {
        CustomerModel customerModel = new CustomerModel();

        customerModel.setId(id);
        customerModel.setNome("Nome");

        return java.util.Optional.of(customerModel);
    }
}