package br.com.glaucioqueiroz.APIProject.Controller;

import br.com.glaucioqueiroz.APIProject.Domain.Interface.ICustomerSerivce;
import br.com.glaucioqueiroz.APIProject.Domain.Service.CustomerSerivce;
import br.com.glaucioqueiroz.APIProject.ViewModel.CustomerViewModel;
import javassist.NotFoundException;
import org.glassfish.jersey.internal.inject.Custom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
@Controller
public class CustomerController {

    private final ICustomerSerivce customerSerivce;

    public CustomerController(ICustomerSerivce customerSerivce) {
        this.customerSerivce = customerSerivce;
    }

    @GetMapping("")
    public List<CustomerViewModel> getAll() {
        return customerSerivce.GetAll();
    }

    @GetMapping("/{id}")
    public CustomerViewModel get(@PathVariable int id) {
        return customerSerivce.GetById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Long post(@RequestBody CustomerViewModel customer) {
        Long id = customerSerivce.Create(customer);
        return id;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void put(@PathVariable int id,@RequestBody CustomerViewModel customer) throws NotFoundException {
        customerSerivce.Edit(customer,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) throws NotFoundException {
        customerSerivce.Delete(id);
    }
}
