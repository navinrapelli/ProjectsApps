<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style >

.error {
  color: #F00;

}
.c{

  border:2px red ridge;
}
</style>
<title>Insert title here</title>
</head>
<body>
<h1>Ajax Form</h1>
<hr>

<form  id="frm1" >
<h1>Personal Info</h1>
User Name<input id="username"  type="text" class="form-control " name="Username"/>
         <small class="form-text text-danger m1-2 form-name-msg"></small><br>
        
         <br>
Email ID <input id="email" type="email" class="form-control " name="Email"/><br>
         <small class="form-text text-danger form-email-msg m1-2"></small><br>
Password <input id="pass"  type="password"class="form-control " name="Pass"/><br>
         <small class="form-text text-denger m1-2 form-pass-msg"></small><br>
Mobile Number <input id="num"  type="number" class="form-control " name="Monumber"/><br>
         <small class="form-text text-denger m1-2 form-num-msg"></small><br>
         <br>
          <p id="ss"></p>
<input type="submit" class="btn btn-success " id="personal"  value="Submit Details" />

</form>

<hr>
<h1>Address</h1>
<form  id="frm2"  method="POST">


Street or house no: <input type="text" id="street"    class="form-control Street" name="Street"/>
         <small class="form-text text-danger m1-2 form-name-msg"></small><br><br>
State <input type="text" class="form-control State " id="state"  name="State"/><br>
         <small class="form-text text-danger form-email-msg m1-2"></small><br>
City <input type="text"class="form-control City" id="city" name="City"/><br>
         <small class="form-text text-denger m1-2 form-pass-msg"></small><br>
Pincode <input type="number" class="form-control Pincode"id="pincode"  name="Pincode"/><br>
         <small class="form-text text-denger m1-2 form-num-msg"></small><br>
         <br>
         <p id="ss1"></p>
<input type="submit" class="btn btn-success " id="address"  value="Submit Details" />

</form>


<hr>
<h1>Occupation Details</h1>
<form  id="frm3"  >
Company Name <input type="text" class="form-control Cmpname" id="comname" name="Cmpname"/>
         <small class="form-text text-danger m1-2 form-name-msg"></small><br>
         <br>
Role <input type="text" class="form-control Role" id="role" name="Role"/><br>
         <small class="form-text text-danger form-email-msg m1-2"></small><br>
Company Location <input type="text"class="form-control loc" id="loc"  name="Loc"/><br>
         <small class="form-text text-denger m1-2 form-pass-msg"></small><br>
         <br>
         <p id="ss2"></p>
<input type="submit" class="btn btn-success " id="occupation" value="Submit Details" />

</form>
         



<script type="text/javascript"   src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
<script src="form.js"></script>



</body>
</html>