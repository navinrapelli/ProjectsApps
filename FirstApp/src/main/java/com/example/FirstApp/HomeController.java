package com.example.FirstApp;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.FirstApp.dao.CityRepo;
import com.example.FirstApp.dao.StateRepo;
import com.example.FirstApp.dao.UserRepo;


@Controller
public class HomeController {

	
	@Value("${uploadDir}")
	private String uploadFolder;
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	StateRepo staterepo;
	
	@Autowired
	CityRepo cityrepo;
	
	
	@RequestMapping("/jstl")
	public String JSTLE()
	{
		 System.out.print("navin");
		 return "JSTLE";
	}
	
	
	@RequestMapping("/table")
	public String table()
	{
		return "tablejsp";
		
	}
	
	
	@RequestMapping("/img")
	public String Image()
	{
		 System.out.print("navin");
		 return "img";
	}
	
	@RequestMapping("/fun")
	public String JSTLEFunctional()
	{
		 System.out.print("navin");
		 return "FunctionalTags";
	}
	
	@RequestMapping("/Profile")
	public String Profile()
	{
		 return "Profile";
	}
	
	
	
	
	
	
	

	@RequestMapping("/login")
	public String Login( HttpServletRequest request,Model m)
	{  		
		
//		Cookie[] cookies= request.getCookies();
//		for(Cookie temp:cookies) {
//		
//		if("userCookie".equals(temp.getName())) {
//			
//			String myUsername=temp.getValue();
//			m.addAttribute("previousname", myUsername);
//				
//			}
//			
		
//	}
		

		  HttpSession session=request.getSession();
		
		 String name=(String)session.getAttribute("usersession");
		  
		 m.addAttribute("previousname", name);
		 
		 
		 
		 return "login";
	}
		@RequestMapping("/userr")
	public String Userdetails(Model m)
	{  //@CookieValue("userCookie")String use
	
	//m.addAttribute("username", use);

		List<StateEntity> states=(List<StateEntity>) staterepo.findAll();

	    m.addAttribute("states", states)	;	
	 return "userdetails";
	}	
	 

	@RequestMapping("/profile")
	public String LogProfile(UserRegistration regg,Model m ,@RequestParam String Usernamee,@RequestParam String Pass,HttpServletRequest request)
	{
		
		
		System.out.println(Usernamee+Pass);
		
		try{

			UserRegistration pro=repo.findByUsernameAndPass(Usernamee,Pass);
			String userr=pro.getUsername();
			  Long id=pro.getUID();
	         
			//Create cookie for username  
//			  Cookie theCookie=new Cookie("userCookie", userr);
//			  theCookie.setMaxAge(60*60*24);
//			
//			  //add the cookie for the response 
//			  
//			  response.addCookie(theCookie);
			  
			  
			  HttpSession session=request.getSession(); //Createing cookie and adding and managing cookie
			  session.setAttribute("usersession",userr);
			  
			  
				System.out.println(Usernamee);
				 return "redirect:/pro/"+id;
			
			
		}catch(Exception ex){
			
        
			m.addAttribute("resulttt", "Password or user name is incorrect or New User");
			//session.setAttribute("sess","Password is inccorect ");
			return "login";
			
			
			
		}
		
			
			

		
		
	
	
	
	
	

	}
	
	
	@RequestMapping("/pro/{UID}")
	public String Profiletwo(UserRegistration regg,Model m,@PathVariable(name="UID")Long UID)
	{ 
       UserRegistration profile= repo.findById(UID).get();
		
		m.addAttribute("profile", profile);
		
		 return "Profiletwo";
	}
	
	
	
	@RequestMapping("/format")
	public String Format()
	{
		 return "FormatingTags";
	}
	

	
	@RequestMapping("/search")
	public String getalluserss(Model m,UserRegistration reg)
	{   
          
	List<UserRegistration> resultt=(List<UserRegistration>) repo.findAll();

	    m.addAttribute("resultt", resultt);
		return "Search";
		
		
	}
	
	
	
	@RequestMapping("/image/{UID}")
	void showimage(UserRegistration regg,@PathVariable(name="UID")Long UID,HttpServletResponse response) throws IOException {
		
		UserRegistration body= repo.findById(UID).get();
		
		response.setContentType("image/jpeg,image/jpg,image/png,image/gif");
		
		response.getOutputStream().write(body.getImage());
		
		System.out.println("from show"+body.getImage());
		
		response.getOutputStream().close();
		
	}
	
	
	
	
	@RequestMapping("/wel")
	public String home()
	{
		 System.out.print("navin");
		 return "home";
	}
	
	
	@RequestMapping("/regform")
	public String register(UserRegistration reg,Model m)
	{ 
		List<StateEntity> states=(List<StateEntity>) staterepo.findAll();

	    m.addAttribute("statess", states);
		return "registration";
		
	}
	
	
	
	
	//@PostMapping("/add")

    @RequestMapping(value = { "/add" }, consumes = {"multipart/form-data"},method = RequestMethod.POST)
	public String adduser(UserRegistration reg, BindingResult result,@RequestParam("image")MultipartFile file,HttpServletRequest request) throws IOException {
		
		String uploadDirectory=request.getServletContext().getRealPath(uploadFolder);
		String fileName=file.getOriginalFilename();
		String filePath=Paths.get(uploadDirectory, fileName).toString();

		System.out.println(uploadDirectory);
		System.out.println(file.getOriginalFilename()+file.getName());
		System.out.println("this is the image data");
		
		System.out.println(	reg.getImage());
		
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
		
		reg.setImage(imageData);
	              System.out.println(reg);
	           
	              
	       System.out.println(reg.getState());    
       int idd=  Integer.parseInt( reg.getState());          
       StateEntity sat=staterepo.findById(idd).get();
	            
	              reg.setState(sat.getStatename());
		repo.save(reg);
		
		
		return "redirect:/main";
	 
		
		
		
		
		
	}
	
	
	
	
	
	
	
	//@PostMapping("/save/{UID}/{page}")
  
    @RequestMapping(value = { "/save/{UID}/{page}" },consumes = {"multipart/form-data"},method = RequestMethod.POST)
	public String userinfo( UserRegistration regg,BindingResult result,@PathVariable(name="UID")String UID,@PathVariable("page")String page, @RequestParam ("image")MultipartFile file,HttpServletRequest request) throws IOException 
	{    
	
		
		try{
		    Long i = (long) Integer.parseInt(UID);

			regg.setUID(i);
			
			System.out.println("from save "+regg);
			
			if(regg.getGender()==null || regg.getLanguages()==null ||regg.getCity()== "Default")
			{ 
				
				return "redirect:/editemp/{UID}";
				
			}else {
				 
		    	String uploadDirectory=request.getServletContext().getRealPath(uploadFolder);
				String fileName=file.getOriginalFilename();
				String filePath=Paths.get(uploadDirectory, fileName).toString();

				System.out.println(uploadDirectory);
				System.out.println(file.getOriginalFilename()+file.getName());
				System.out.println("this is the image data");
				
				System.out.println(	regg.getImage());
				
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
				regg.setImage(imageData);
				System.out.println(regg.getState());    
			       int idd=  Integer.parseInt( regg.getState());          
			       StateEntity sat=staterepo.findById(idd).get();
				            
				              regg.setState(sat.getStatename());
				
				repo.save(regg);
				
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
			
			
			return "redirect:/pro/"+UID;
		}else {
			
			
			return "redirect:/main";
		}
		
		
		
		
	}
	
//	@RequestMapping("/operation")
//	public ModelAndView operation( Long UID,String flag)
//	{   
//		if(flag.equals("select"))
//		{    
//		
//		     UserRegistration reg= repo.findById(UID).get();
//		       return show(reg);
//		}
//		else if(flag.equals("delete"))
//		{ 
//			repo.deleteById(UID);
//		
//		}
//		else if(flag.equals("update"))
//		{ 
//
//		     UserRegistration reg= repo.findById(UID).get();
//		     
//		     
//		
//		}
//		return new ModelAndView("userdetails");
//		
//	}

	
	public  ModelAndView show(UserRegistration reg)
	{
		ModelMap model=new ModelMap();
		
		 model.addAttribute("name",reg.getUsername() );
		 model.addAttribute("email",reg.getEmail() );
		model.addAttribute("gender",reg.getGender());
		 ModelAndView mv=new ModelAndView("userdetails");
		 mv.addObject("regObj", model);
		return mv;
		
	}
	
	@RequestMapping("/home")
	public String main(UserRegistration reg)
	{  
		
		return "main";
		
	}
	
	/*@RequestMapping(value="/all" ,method = RequestMethod.GET)
	public List<UserRegistration> getalluserss()
	{  
        
      List<UserRegistration> resultt=new ArrayList();
      repo.findAll().forEach(resultt::add);
      
      System.out.println(resultt);
		return resultt ;
		
		
	}*/
	
	
	
	
    @RequestMapping("/main")
	public String getallusers(Model m,UserRegistration reg) 
	{   
		 
   
		
		/*String uploadDirectory=request.getServletContext().getRealPath(uploadFolder);
		String fileName=file.getOriginalFilename();
		String filePath=Paths.get(uploadDirectory, fileName).toString();

		
		System.out.println(file.getOriginalFilename()+file.getName());
		System.out.println("this is the image data");
		
		System.out.println(	reg.getImage());
		
		try {
			
			File dir=new File(uploadDirectory);
			if(!dir.exists()) {
				
				dir.mkdirs();
			}
			//save the file locally
			
			BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		 
		byte[] imageData=file.getBytes();
		
		reg.setImage(imageData);
	              
		repo.save(reg);*/
	 
          
	List<UserRegistration> resulttt=(List<UserRegistration>) repo.findAll();
//		
//		List user=new ArrayList();
//	    repo.findAll().forEach(user::add);
////		m.addAttribute("user", user);
//		System.out.println(user);
	
	System.out.println(resulttt);
	    m.addAttribute("result", resulttt);
		return "main";
		
		
	}

	 //@RequestMapping(value = { "/deleteemp/{UID}/{page}" },  consumes = {"multipart/form-data"})
	
	//@RequestMapping("/deleteemp/{UID}/{page}")
	
	//@RequestMapping(value="/deleteemp/{UID}/{page}", method = RequestMethod.PUT)
	
    //@DeleteMapping("/deleteemp/{UID}/{page}")
    @RequestMapping(value="/deleteemp/{UID}/{page}", method = RequestMethod.GET)
	public String delteuser(@PathVariable("UID")Long UID ,@PathVariable("page")String page)
	{  System.out.println(UID);
	   System.out.println(page);
		repo.deleteById(UID);
		
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
	
	@RequestMapping(value="/editemp/{UID}/{page}", method = RequestMethod.GET)
	public String updateuser(@PathVariable(name="UID")Long UID ,Model m,UserRegistration reg,@PathVariable(name="page")String page)
	{   
		
		UserRegistration body= repo.findById(UID).get();
		//reg.setImage(null);
		m.addAttribute("up", body);
		
		List<StateEntity> states=(List<StateEntity>) staterepo.findAll();

	    m.addAttribute("statess", states);

		return "updatet";
		
	}
	
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String uploadfile()
	{ 
		
		//@RequestParam("file")MultipartFile file
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getName());
//		System.out.println(file.getContentType());
//		
		return "Profile";
		
		
	}
	
	
	
	//State 
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


//Form
@RequestMapping("/form")
public String Form()
{
	 return "Form";
}

//,@RequestParam String Email,@RequestParam String Pass,@RequestParam Long Monumber
@RequestMapping("/form/personal")
@ResponseBody
public List<Object> FormPersnal(@RequestParam String username,@RequestParam String email,@RequestParam String pass,@RequestParam Long num)
{ 
	
	if(username.equals(null)||email.equals(null)||pass.equals(null)||num.equals(null))
	{
		
		
		
	}else {
		
		
		List<Object>list=Arrays.asList(username,email,pass,num);
		
		 return list;
	}
	return null;
	
	
}


@RequestMapping("/form/adress")
@ResponseBody
public List<Object> FormAdress(@RequestParam String street,@RequestParam String state,@RequestParam String city,@RequestParam Integer pincode)
{ 
	List<Object>list1=Arrays.asList(street,state,city,pincode);
	
	 return list1;
}


@RequestMapping("/form/occupation")
@ResponseBody
public List<Object> FormOcuupation(@RequestParam String comname,@RequestParam String role,@RequestParam String loc)
{ 
	
	if(comname.equals(null)||role.equals(null)||loc.equals(null))
	{
		
		
		
	}else {
		
		
		List<Object>list2=Arrays.asList(comname,role,loc);
		
		 return list2;
	}
	return null;
	
}

	
	
}