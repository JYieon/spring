/**
 * 
 */
function daumPost(){
	new daum.Postcode({
        oncomplete: function(data) {
            console.log(data.zonecode)
            document.getElementById("addr1").value = data.zonecode
            let addr = "";
            if( data.userSelectedType == "J" ){
            	addr = data.jibunAddress
            }else{
            	addr = data.roadAddress
            }
            document.getElementById("addr2").value = addr
            document.getElementById("addr3").focus()
        }
    }).open();
}