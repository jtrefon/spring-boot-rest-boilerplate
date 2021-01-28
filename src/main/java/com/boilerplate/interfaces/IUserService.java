/**
 * 
 */
package com.boilerplate.interfaces;
import java.util.List;

import com.boilerplate.entities.User;
/**
 * @author jacektrefon
 *
 */
public interface IUserService {
	List<User> findAll();
	void save(User newUser);
	void delete(Long id);
	User findOneById(Long id);
}
