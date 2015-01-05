package net.xaviersala

import java.util.Date;

class Enquesta {	
	String nomEnquesta = ""
	String pregunta
	boolean identificacio = false
	byte[] imatge
	Date dateCreated
	
	static belongsTo = [ usuari: Usuari ]
	static hasMany = [ opcions: Opcio, registres: Registre ]
	
    static constraints = {
		nomEnquesta blank: true
		pregunta blank: false
		identificacio default:false
		imatge nullable:true
		usuari()
		opcions()
    }
	
	static mapping = {		
		identificacio defaultValue: false
	 }
	
	String toString() {
		"$nomEnquesta"
	}
	

	
}
