package br.com.glaucioqueiroz.APIProject.Domain.Service;

import br.com.glaucioqueiroz.APIProject.CrossCutting.Security.JWTUserDetailsData;
import br.com.glaucioqueiroz.APIProject.DataModel.UserModel;
import br.com.glaucioqueiroz.APIProject.Domain.Interface.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticationService implements UserDetailsService {

    private final IUserRepository repository;

    public AuthenticationService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> usuario = repository.findByLogin(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("USER [" + username + "] NOT FOUND");
        }
        return new JWTUserDetailsData(usuario);
    }

}

