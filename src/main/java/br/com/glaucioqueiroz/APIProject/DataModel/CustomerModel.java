package br.com.glaucioqueiroz.APIProject.DataModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity(name="Customer")
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String cpf;
    private String nome;

//    @OneToMany(mappedBy = "customer",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true, targetEntity = AddressModel.class)
//    public List<AddressModel> endereco = new ArrayList<>();

    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
}
