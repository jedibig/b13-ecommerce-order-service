package com.b13.orderservice.service;

import com.b13.orderservice.dto.Order;

public class CreditCardUtil {
	
	private static Order maskCreditCard(Order p){
		String strText= p.getCreditCardNumber();
		
		if(strText == null || strText.equals(""))
			p.setCreditCardNumber( "");
        int start=0;
        int end=12>strText.length()?12:strText.length();
        char maskChar='*';
        
        int maskLength = end - start;
        
        if(maskLength == 0)
        	 p.setCreditCardNumber("");
        
        StringBuilder sbMaskString = new StringBuilder(maskLength);
        
        for(int i = 0; i < maskLength; i++){
            sbMaskString.append(maskChar);
        }
        
        p.setCreditCardNumber( strText.substring(0, start) 
            + sbMaskString.toString() 
            + strText.substring(start + maskLength));
        return p;
	   }
	
	
}
