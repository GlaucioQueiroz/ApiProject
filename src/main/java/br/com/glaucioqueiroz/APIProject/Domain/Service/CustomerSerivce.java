package br.com.glaucioqueiroz.APIProject.Domain.Service;

import br.com.glaucioqueiroz.APIProject.DataModel.AddressModel;
import br.com.glaucioqueiroz.APIProject.DataModel.CustomerModel;
import br.com.glaucioqueiroz.APIProject.Domain.Interface.ICustomerRepository;
import br.com.glaucioqueiroz.APIProject.Domain.Interface.ICustomerSerivce;
import br.com.glaucioqueiroz.APIProject.ViewModel.CustomerViewModel;
import javassist.NotFoundException;
import org.aspectj.weaver.ast.Not;
import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerSerivce implements ICustomerSerivce {
    private final ICustomerRepository repository;

    public CustomerSerivce(ICustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerViewModel GetById(int id){
        CustomerModel customer = repository.findById(id).orElseThrow();
        return new ModelMapper().map(customer,CustomerViewModel.class);
    }

    public List<CustomerViewModel> GetAll(){
        List<CustomerModel> customers = repository.findAll();
        return new ModelMapper().map(customers, new TypeToken<List<CustomerViewModel>>() {}.getType());
    }

    public long Create(CustomerViewModel customer){
        CustomerModel newCustomer =  new ModelMapper().map(customer,CustomerModel.class);
        CustomerModel customerModel = repository.saveAndFlush(newCustomer);

        return customerModel.getId();
    }

    public void Edit(CustomerViewModel customer,int id) throws NotFoundException {
        CustomerModel editCustomer = repository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found - "));
        if(editCustomer.getId()!=null){
            editCustomer =  new ModelMapper().map(customer,CustomerModel.class);
            editCustomer.setId(id);
            repository.saveAndFlush(editCustomer);
        }else{
            throw new NotFoundException("Customer Not Found");
        }
    }

    public void Delete(int id)throws NotFoundException {
        CustomerModel customer = repository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found - "));
        if(customer.getId()!=null){
            repository.deleteById(customer.getId());
        }else{

            throw new NotFoundException("Customer Not Found");
        }
    }
}
