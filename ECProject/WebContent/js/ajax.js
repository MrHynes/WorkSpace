function createXMLRequest(){
	
	if(window.XMLHttpRequest) {
  			
  			return new XMLHttpRequest();
  			
  		} else if(window.ActiveXObject) {
  			
  			try {
  				
  				return new ActiveXObject("Msxml2.XMLHTTP");
  				
  				
  			} catch(e) {
  				
  				try {
  					
  					return new ActiveXObject("Microsoft.XMLHTTP");
  					
  				} catch(e) {
  					
  					alert("对象无法创建！");
  					return false;
  				}
  				
  				
  			}
  			
  			
  		}
	
	
}