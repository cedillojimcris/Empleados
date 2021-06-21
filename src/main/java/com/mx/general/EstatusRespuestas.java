package com.mx.general;

public class EstatusRespuestas {

	String mensaje;
	String resp;
	Object obj;
	public EstatusRespuestas() {
	}
	public EstatusRespuestas(String mensaje, String resp, Object obj) {
		this.mensaje = mensaje;
		this.resp = resp;
		this.obj = obj;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getResp() {
		return resp;
	}
	public void setResp(String resp) {
		this.resp = resp;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "EstatusRespuestas [mensaje=" + mensaje + ", resp=" + resp + ", obj=" + obj + "]";
	}
	
}
