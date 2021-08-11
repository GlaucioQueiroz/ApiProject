package br.com.glaucioqueiroz.APIProject.Domain.Interface;

import br.com.glaucioqueiroz.APIProject.DataModel.CustomerModel;
import br.com.glaucioqueiroz.APIProject.ViewModel.CustomerViewModel;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public interface ICustomerSerivce {
    public CustomerViewModel GetById(int id);

    public List<CustomerViewModel> GetAll();

    public long Create(CustomerViewModel customer);

    public void Edit(CustomerViewModel customer, int id) throws NotFoundException;

    public void Delete(int id) throws NotFoundException;
}