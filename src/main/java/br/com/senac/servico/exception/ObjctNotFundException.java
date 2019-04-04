package br.com.senac.servico.exception;

public class ObjctNotFundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public  ObjctNotFundException(String msg) {
		super(msg);
	}
	public  ObjctNotFundException(String msg, Throwable cause ) {
		super(msg, cause);
	}

}
