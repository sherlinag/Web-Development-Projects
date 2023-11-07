let digitValidate = function(ele){
    console.log(ele.value);
    ele.value = ele.value.replace(/[^0-9]/g,'');
  }
  
  let tabChange = function(val){
      let ele = document.querySelectorAll('input');
      if(ele[val-1].value != ''){
        ele[val].focus()
      }else if(ele[val-1].value == ''){
        ele[val-2].focus()
      }   
   }
const form = document.getElementById("otpForm");
form.addEventListener("submit", function(event) {
  event.preventDefault();
  const otpCode = document.getElementById("otpCode").value;
  if (otpCode.length === 6 && /^\d+$/.test(otpCode)) {
    alert("OTP code is valid");
    // Here you can add your own code to send the OTP code to the server for validation.
  } else {
    alert("OTP code is invalid");
  }
});
