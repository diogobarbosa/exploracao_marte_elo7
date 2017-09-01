package org.diogobarbosa.exploracaomartecore.excecoes;

public class InstrucaoInvalidaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6704863433275327054L;

	private String msg;
	
    public InstrucaoInvalidaException(String msg){
      super(msg);
      this.msg = msg;
    }
    
    public String getMessage(){
        return msg;
    }
}
