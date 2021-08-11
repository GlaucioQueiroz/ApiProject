package br.com.glaucioqueiroz.APIProject.Domain.Interface;

import br.com.glaucioqueiroz.APIProject.DataModel.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<CustomerModel, Integer> {
}
