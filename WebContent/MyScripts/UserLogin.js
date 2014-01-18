function fun()
{

               if(document.myform1.userSapientEmail.value=="" ||(document.myform1.userSapientEmail.value=="Sapient Email"))
                    {
                     alert(" SapientEmail cannot be blank");
                 
                    }
               else if (document.myform1.userPassword.value=="" || document.myform1.userPassword.value=="Password")
               {
                alert("Password cannot be balnk");
                document.myform1.userEmail.focus();
               }
               
               
               else 
                   {
                    //alert("you are registered");
                    document.myform1.submit();
                
                   }
               
}
