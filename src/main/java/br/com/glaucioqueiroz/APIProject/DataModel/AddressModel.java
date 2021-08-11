package br.com.glaucioqueiroz.APIProject.DataModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity(name="Address")
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer Id;

    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;

//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private CustomerModel customer;
}
