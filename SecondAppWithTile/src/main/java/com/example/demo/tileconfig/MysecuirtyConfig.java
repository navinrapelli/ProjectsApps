package com.example.demo.tileconfig;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.example.demo.service.CustomUserDetailService;




@Configuration
@EnableWebSecurity
public class MysecuirtyConfig extends WebSecurityConfigurerAdapter{

	@Value("#{'${mypermitall.list.of.strings}'.split(',')}") 
	private String[] myPermitList;
	
	@Value("#{'${myuser.list.of.strings}'.split(',')}") 
	private String[] myUserList;
	
	@Value("#{'${myadmin.list.of.strings}'.split(',')}") 
	private String[] myAdminList;
	
	
//	
//	String[] newlist = new String[myList.size()];
//	newlist = myList.toArray(newlist);
	
	
	
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
////		// String [] newlist = myList.toArray(new String[myList.size()]);
////		 String arrayy[] = new String[myList.size()];              
////			for(int j =0;j<myList.size();j++){
////			  arrayy[j] = myList.get(j);
////			}
//			
//			System.out.println(arrayy);
//			System.out.println(Arrays.toString(arrayy));
//			
//		String n=Arrays.toString(arrayy);
		
	//    System.out.println(myList[0]);
		
		
		String[] myPermitList1 = myPermitList;
		String[] myUserList1 = myUserList;
		String[] myAdminList1 = myAdminList;
		http 
		     .csrf().disable()
		     .authorizeRequests()
     	     .antMatchers(myPermitList1).permitAll()//which dont need authoindication
		     .antMatchers(myUserList1).hasRole("USER")
		     .antMatchers(myAdminList1).hasRole("ADMIN")
		     .anyRequest()
		     .authenticated()
		     .and()
		     .formLogin()
		     .loginPage("/login")
		     .loginProcessingUrl("/dologin")
		     .successForwardUrl("/profiled")
		     .and()
		     .logout()
		     .logoutSuccessUrl("/wel");
		
		
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		
		auth.userDetailsService(customUserDetailService).passwordEncoder(bCryptPasswordEncoder());
		
//		auth.inMemoryAuthentication().withUser("navin").password(this.bCryptPasswordEncoder().encode("baba")).roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("shital").password(this.bCryptPasswordEncoder().encode("abc")).roles("USER");
	}

	
	//Role- high level overview -> normal READ
	//Authority- Permission  -> READ
	//Admin read, write ,update
	

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder(10);
		
		
	}
	
	
}