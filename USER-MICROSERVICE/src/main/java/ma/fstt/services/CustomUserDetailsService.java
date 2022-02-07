//package ma.fstt.lsi.services;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import ma.fstt.lsi.entities.AppRole;
//import ma.fstt.lsi.entities.AppUser;
//import ma.fstt.lsi.repositories.AppRoleRepository;
//import ma.fstt.lsi.repositories.AppUserRepository;
//
//@Service
//public class CustomUserDetailsService {
//	
//	@Autowired
//	private AppUserRepository userRepository;
//	@Autowired
//	private AppRoleRepository roleRepository;
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	public AppUser findUserByEmail(String email) {
//	    return userRepository.findByEmail(email);
//	}
//	
//	public AppUser saveUser(String username,String email, String adress, String password, String confirmedPassword) {
//		
//		//------- verify if user exist --------
//		AppUser user = userRepository.findByUsername(username);
//		if(user != null) throw new RuntimeException("User already exists");
//		if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
//						
//		//------------ Create User ---
//		AppUser appUser = new AppUser();
//		appUser.setUsername(username);
//		appUser.setEmail(email);
//		appUser.setAdress(adress);
//		appUser.setActived(true);
//		appUser.setPassword(bCryptPasswordEncoder.encode(password));
//		AppRole userRole = roleRepository.findByRoleName("ADMIN");
//		appUser.setRoles(new HashSet<>(Arrays.asList(userRole)));
//		
//		userRepository.save(appUser);
////		addRoleToUser(username, "USER");
//		return appUser;
//	}
//	
//	public AppRole save(AppRole role) {
//		return roleRepository.save(role);
//	}
//
//	//------ check and compare username with the user from MongoDB collection ----
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//	    AppUser user = userRepository.findByEmail(email);
//	    if(user != null) {
//	        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
//	        return buildUserForAuthentication(user, authorities);
//	    } else {
//	        throw new UsernameNotFoundException("username not found");
//	    }
//	}
//	
//	//----- method for converting the user roles as GrantedAuthority collection ------
//	private List<GrantedAuthority> getUserAuthority(Set<AppRole> userRoles) {
//	    Set<GrantedAuthority> roles = new HashSet<>();
//	    userRoles.forEach((role) -> {
//	        roles.add(new SimpleGrantedAuthority(role.getRoleName()));
//	    });
//
//	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
//	    return grantedAuthorities;
//	}
//	
//	//------- method for connecting MongoDB user to Spring Security user ---------
//	private UserDetails buildUserForAuthentication(AppUser user, List<GrantedAuthority> authorities) {
//	    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
//	}
//	
//}
