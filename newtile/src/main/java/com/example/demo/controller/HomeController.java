package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	
	

	@Value("${uploadDir}")
	private String uploadFolder;
	
	
	@Autowired
	UserService user;
	

	@Autowired
	StateRepo staterepo;
	
	@Autowired
	CityRepo cityrepo;
	
	
	
	
	@GetMapping("/wel")
	public String hello()
	{
		 return "welcome";
	}
	
	
	@GetMapping("/product")
	public String product()
	{
		 return "product";
	}
	
	


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(@RequestParam(value = "error", required = false) String error, 
            @RequestParam(value = "logout", required = false) String logout,HttpServletRequest request,Model m)
	{
		HttpSession session=request.getSession();
		
		 String name=(String)session.getAttribute("usersession");
		  System.out.println(name+" from login");
		 m.addAttribute("previousname", name);
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
	
	
	@RequestMapping(value = { "/add" }, consumes = {"multipart/form-data"},method = RequestMethod.POST)
	public String adduser(User users, BindingResult result,@RequestParam("image")MultipartFile file,HttpServletRequest request) throws IOException {
		
		String uploadDirectory=request.getServletContext().getRealPath(uploadFolder);
		String fileName=file.getOriginalFilename();
		String filePath=Paths.get(uploadDirectory, fileName).toString();

		System.out.println(uploadDirectory);
		System.out.println(file.getOriginalFilename()+file.getName());
		System.out.println("this is the image data");
		
		System.out.println(	users.getImage());
		
		try {
			
			File dir=new File(uploadDirectory);
			if(!dir.exists()) {
				
				dir.mkdirs();
			}
			//save the file locally
			System.out.println(filePath);
			BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		 
		byte[] imageData=file.getBytes();
		
		users.setImage(imageData);
	              System.out.println(users);
	           
	              
	       System.out.println(users.getState());    
       int idd=  Integer.parseInt( users.getState());          
       StateEntity sat=staterepo.findById(idd).get();
	            
       users.setState(sat.getStatename());
       user.addUser(users);
		
		
		return "redirect:/login";
	 
		
		
		
		
		
	}
	
	@RequestMapping("/image/{UID}")
	void showimage(User regg,@PathVariable(name="UID")Long UID,HttpServletResponse response) throws IOException {
		
		User body= user.getUser(UID);
		
		response.setContentType("image/jpeg,image/jpg,image/png,image/gif");
		
		response.getOutputStream().write(body.getImage());
		
		System.out.println("from show"+body.getImage());
		
		response.getOutputStream().close();
		
	}
	
	 /* @RequestMapping(value = { "/add" }, method = RequestMethod.POST)
		public String adduser(User users,HttpServletRequest request) {
			     
		
		  

	       System.out.println(users.getState());    
      int idd=  Integer.parseInt( users.getState());          
      StateEntity sat=staterepo.findById(idd).get();
	            
      users.setState(sat.getStatename());
      

	              
	            
			user.addUser(users);
			
			return "redirect:/login";
		 
			
			
			
			
			
		
	  }*/
		
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
			  
			  
			  System.out.println(id+role);
			  if(role.equals("ROLE_ADMIN"))
			  {
				  HttpSession session=request.getSession(); 
				  session.setAttribute("usersession",userr);
				  
				  session.setAttribute("usersessionid",id);
				  System.out.println(userr);
				  return "redirect:/admin/"+id;

				
				  
			  }else if(role.equals("ROLE_USER")) {
				  

				  HttpSession session=request.getSession(); //Createing cookie and adding and managing cookie
				  session.setAttribute("usersession",userr);
				  session.setAttribute("usersessionid",id);
				  
					System.out.println(username);
					 return "redirect:/profilewel/"+id;
				  
				  
			  }
	         
			  
			  System.out.println(userr);
		
			  
			  
			
			
		}catch(Exception ex){
			
        
			m.addAttribute("resulttt", "Password or user name is incorrect or New User");
			
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
	
	
	
	
	
	@RequestMapping(value="/editemp/{UID}", method = RequestMethod.GET)
	public String updateuser(@PathVariable(name="UID")Long UID ,Model m,User reg)
	{   
		
		User body= user.getUser(UID);
		//reg.setImage(null);
		m.addAttribute("up", body);
		
		List<StateEntity> states=(List<StateEntity>) staterepo.findAll();

	    m.addAttribute("statess", states);

		return "updatet";
		
	}
	
	
	 @RequestMapping(value = { "/save/{UID}" },consumes = {"multipart/form-data"},method = RequestMethod.POST)
		public String userinfo( User regg,BindingResult result,@PathVariable(name="UID")String UID)  
		{    
		 String rolee=regg.getRole();
			
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
			
			
			

		if(rolee.equalsIgnoreCase("ROLE_USER")) {
				
				return "redirect:/profile/"+UID;
			}
			else if(rolee.equalsIgnoreCase("second")) {
				
				System.out.println("second");
				
				return "redirect:/search";
				
			}else if(rolee.equalsIgnoreCase("ROLE_ADMIN")){
				
				
				return "redirect:/profileadmin/"+UID;
			}else {
				
				
				return "redirect:/main";
			}
			
			
			
			
		}
	 
	 
//Admin	 

	
		@GetMapping("/admin/{UID}")
		public String admin(User regg,Model m,@PathVariable(name="UID")Long UID)
		{ 
			
			System.out.println("from admin");
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
