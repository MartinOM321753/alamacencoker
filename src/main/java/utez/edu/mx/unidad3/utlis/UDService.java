package utez.edu.mx.unidad3.utlis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utez.edu.mx.unidad3.models.user.BeanUser;
import utez.edu.mx.unidad3.models.user.UserRepository;

import java.util.Collections;

@Service
//Tecer paso : CREAR NUESTRO SEVICIO DE GESTION DE AUTORIDADES
public class UDService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        BeanUser found = userRepository.findByUsername(username).orElse(null);
        if (found == null) {
            throw new UsernameNotFoundException(username);
        }
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+ found.getRol().getName());
        return new User(
                found.getUsername(),
                found.getPassword(),
                Collections.singleton(authority)

        );
    }
}
