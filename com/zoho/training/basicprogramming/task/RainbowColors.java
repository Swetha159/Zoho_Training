package com.zoho.training.basicprogramming.task;

public enum RainbowColors {
		VIOLET(1),INDIGO(2),BLUE(3) ,GREEN (4), YELLOW (5),ORANGE(6),RED(7) ;
	
		private final int CODE;
		
		RainbowColors(int code)
		{
			this.CODE = code;
		}
		
		public int getCode()
		{
			return this.CODE;
		}
	
}
