package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.entity.CityEnity;
import com.example.demo.entity.StateEntity;
import com.example.demo.entity.User;
import com.example.demo.repo.CityRepo;
import com.example.demo.repo.StateRepo;
import com.example.demo.service.UserService;



@Controller
public class HomeController {
	
	
	@Autowired
	UserService user;
	

	@Autowired
	StateRepo staterepo;
	
	@Autowired
	CityRepo cityrepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	@Value("#{'${my.list.of.strings}'.split(',')}") 
//	private List<String> myList;
	
	
	
	
	
	@GetMapping("/wel")
	public String hello()
	{
		
	//	System.out.println(myList);
//		
//		
////
//	String array[] = new String[myList.size()];              
//	for(int j =0;j<myList.size();j++){
//	  array[j] = myList.get(j);
//	}

		//String [] newlist = (String[]) myList.toArray();
		
		
		//System.out.println(Arrays.toString(array));
		 return "welcome";
	}
	
	
	@GetMapping("/product")
	public String product()
	{
		 return "product";
	}
	
	

//	
//	@GetMapping("/profile")
//	public String profile()
//	{
//		 return "profile";
//	}
	
	@GetMapping("/login")
	public String home()
	{
		 return "login";
	}
	
	@GetMapping("/profilewel/{UID}")
	public String profilewel(User regg,Model m,@PathVariable(name="UID")Long UID)
	{ 
		User profilee= user.getUser(UID);
		m.addAttribute("profileee", profilee);
		 return "profilewel";
	}
	
	
	
	@GetMapping("/contact")
	public String contact()
	{
		 return "contact";
	}
	
	
	@GetMapping("/headerpro/{UID}")
	public String headerpro()
	{
		 return "headerpro";
	}
	
	
	@GetMapping("/regform")
	public String regform(Model m)
	{  
		List<StateEntity> states=(List<StateEntity>) staterepo.findAll();

	    m.addAttribute("statess", states);
		 return "regform";
	}
	
	
	  @RequestMapping(value = { "/add" }, method = RequestMethod.POST)
		public String adduser(User users) {
			     
		
		  

	       System.out.println(users.getState());    
      int idd=  Integer.parseInt( users.getState());          
      StateEntity sat=staterepo.findById(idd).get();
	            
      users.setState(sat.getStatename());
	              
	              System.out.println(users.getPass()+ "ur password is");
	              
	              users.setPass(this.bCryptPasswordEncoder.encode(users.getPass()));
			user.addUser(users);
			
			return "redirect:/login";
		 
			
			
			
			
			
		
	  }
		
	  @RequestMapping("/city")
		public void getallcityes(Model m) 
		{    
	          
		List<CityEnity> city=(List<CityEnity>) cityrepo.findAll();

		    m.addAttribute("city", city);
		    
		    System.out.println(city);
			
			
			
		}
		

	@RequestMapping("/city/{stid}")
	@ResponseBody
	public List<CityEnity> getallcity(Model m,@PathVariable(name="stid")Integer stid) 
	{    
	      
	List<CityEnity> city=(List<CityEnity>) cityrepo.findByStid(stid);

	    //m.addAttribute("citys", city);
	    System.out.println(city);
	    
	    
		  return city;
	    
	    
		
		
		
	}
	@RequestMapping("/profiled")
	public String LogProfile(User regg,Model m ,@RequestParam String username,@RequestParam String password,HttpServletRequest request)
	{
		
		
		System.out.println(username+password);
		
		try{

			User pro=user.getUserwithUsername(username);
			String userr=pro.getUsername();
			  Long id=pro.getUID();
			  
			  String role=pro.getRole();
			  
			  if(role.equals("ROLE_ADMIN"))
			  {
				  
				  HttpSession session=request.getSession(); 
				  session.setAttribute("usersession",userr);
				  
				  session.setAttribute("usersessionid",id);
				  return "redirect:/admin/"+id;
				  
				  
			  }else if(role.equals("ROLE_USER")) {
				  

				  HttpSession session=request.getSession(); 
				  session.setAttribute("usersession",userr);
				  
				  session.setAttribute("usersessionid",id);
				  
				  
					System.out.println(username);
					 return "redirect:/profilewel/"+id;
				  
				  
			  }
	         
			  
			  System.out.println(userr);
			//Create cookie for username  
//			  Cookie theCookie=new Cookie("userCookie", userr);
//			  theCookie.setMaxAge(60*60*24);
//			
//			  //add the cookie for the response 
//			  
//			  response.addCookie(theCookie);
			  
			  
			
			
		}catch(Exception ex){
			
        
			m.addAttribute("resulttt", "Password or user name is incorrect or New User");
			//session.setAttribute("sess","Password is inccorect ");
			return "login";
			
			
			
		}
		
		
			
			
		return "login";
		
		
	
	
	
	
	

	}
	
	
	
	
	
	
	
	@RequestMapping("/profile/{UID}")
	public String Profiletwo(User regg,Model m,@PathVariable(name="UID")Long UID)
	{ 
		User profile= user.getUser(UID);
		
		
		
		m.addAttribute("profile", profile);
		
		 return "profile";
	}
	
	
	
	
	
	@RequestMapping(value="/editemp/{UID}/{page}", method = RequestMethod.GET)
	public String updateuser(@PathVariable(name="UID")Long UID ,Model m,User reg,@PathVariable(name="page")String page)
	{   
		
		User body= user.getUser(UID);
		//reg.setImage(null);
		m.addAttribute("up", body);
		
		List<StateEntity> states=(List<StateEntity>) staterepo.findAll();

	    m.addAttribute("statess", states);

		return "updatet";
		
	}
	
	
	 @RequestMapping(value = { "/save/{UID}/{page}" },method = RequestMethod.POST)
		public String userinfo( User regg,BindingResult result,@PathVariable(name="UID")String UID,@PathVariable("page")String page)  
		{    
		
			
			try{
			    Long i = (long) Integer.parseInt(UID);

				regg.setUID(i);
				
				System.out.println("from save "+regg);
				
				if(regg.getGender()==null || regg.getLanguages()==null ||regg.getCity()== "Default")
				{ 
					
					return "redirect:/editemp/{UID}";
					
				}else {
					 
			    	
					System.out.println(regg.getState());    
				       int idd=  Integer.parseInt( regg.getState());          
				       StateEntity sat=staterepo.findById(idd).get();
					            
					              regg.setState(sat.getStatename());
					
					              user.editUser(regg);
					
				}
				
			} catch(Exception ex){ // handle your exception
			   ex.getMessage() ;
			}
			
			
			

		if(page.equalsIgnoreCase("first")) {
				
				return "redirect:/main";
			}
			else if(page.equalsIgnoreCase("second")) {
				
				System.out.println("second");
				
				return "redirect:/search";
				
			}else if(page.equalsIgnoreCase("third")){
				
				
				return "redirect:/profile/"+UID;
			}else {
				
				
				return "redirect:/main";
			}
			
			
			
			
		}
	 
	 
//Admin	 

	
		@GetMapping("/admin/{UID}")
		public String admin(User regg,Model m,@PathVariable(name="UID")Long UID)
		{ 
			User profilee= user.getUser(UID);
			m.addAttribute("profileee", profilee);
			 return "admin";
		}
		
		
		@RequestMapping("/profileadmin/{UID}")
		public String Profiletwoadmin(User regg,Model m,@PathVariable(name="UID")Long UID)
		{ 
			User profile= user.getUser(UID);
			
			
			
			m.addAttribute("profile", profile);
			
			 return "profileadmin";
		}
		
		
		
		
		
		   @RequestMapping("/main")
			public String getallusers(Model m,User reg) 
			{   
				 
		   
			 
		          
			List<User> resulttt= user.getAllUsers();
			
			System.out.println(resulttt);
			    m.addAttribute("result", resulttt);
				return "main";
				
				
			}

		    @RequestMapping(value="/deleteemp/{UID}/{page}", method = RequestMethod.GET)
			public String delteuser(@PathVariable("UID")Long UID ,@PathVariable("page")String page)
			{  System.out.println(UID);
			   System.out.println(page);
			    
			   
			   user.deleteUser(UID);
				
				if(page.equalsIgnoreCase("first")) {
					
					return "redirect:/main";
				}
				else if(page.equalsIgnoreCase("second")) {
					
					System.out.println("second");
					
					return "redirect:/search";
					
				}else {
					
					
					return "redirect:/main";
				}
				
				
				
			
				
			}
	

}
