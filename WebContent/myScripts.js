/**
 * 
 */
function fun()
{
alert("in Fun");
               if(document.myform1.adminUserName.value=="")
                    {
                     alert(" User name cannot be blank");
                     document.myform1.adminUserName.focus();
                 
                    }
               else if (document.myform1.adminPassword.value=="")
               {
                alert("Password cannot be balnk");
                document.myform1.adminPassword.focus();
               }
               
               
               else 
                   {
                    //alert("you are registered");
                    document.myform1.submit();
                
                   }
               
}