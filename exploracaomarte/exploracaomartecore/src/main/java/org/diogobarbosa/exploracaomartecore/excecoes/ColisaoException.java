package org.diogobarbosa.exploracaomartecore.excecoes;

public class ColisaoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8987570480611224747L;
	
	private String msg;
	
    public ColisaoException(String msg){
      super(msg);
      this.msg = msg;
    }
    
    public String getMessage(){
        return msg;
    }
}
