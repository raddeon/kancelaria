package pl.fastdev.kancelaria.bean.logowanie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.fastdev.kancelaria.model.UserEntity;

@Service("userDetailsService") 
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired private UserDao dao;
  @Autowired private Assembler assembler;

  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException, DataAccessException {

    UserEntity userEntity = null;
    try {
    	userEntity = dao.findByName(username);
    } catch (DuplicateEntityException ex) {
    	// jeœli nie ma takiego usera to rzucamy wyj¹tkiem zeby SS wiedzia³o co robiæ :)
      throw new UsernameNotFoundException("user not found");
    }

    return assembler.buildUserFromUserEntity(userEntity);
  }
}

