package pl.fastdev.kancelaria.bean.logowanie;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.fastdev.kancelaria.model.SecurityRoleEntity;
import pl.fastdev.kancelaria.model.UserEntity;

@Service("assembler")
public class Assembler {

  @Transactional(readOnly = true)
  User buildUserFromUserEntity(UserEntity userEntity) {

    String username = userEntity.getUsername();
    String password = userEntity.getPassword();
    
    //FIXME dkrol hardcode
    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;
    
    System.out.println("Znalazlem: "+ username + "  " + password);

    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for (SecurityRoleEntity role : userEntity.getRoles()) {
      authorities.add(new GrantedAuthorityImpl(role.getRola()));
      System.out.println("ma role: " + role.getRola());
    }

    // s¹ te¿ inne fajne konstruktory
    User user = new User(username, password, enabled,
      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    return user;
  }
}
