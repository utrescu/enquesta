package net.xaviersala

import java.util.Date;

class Enquesta {	
	String nomEnquesta
	String pregunta
	byte[] imatge
	Date dateCreated
	
	static belongsTo = [usuari: Usuari]
	static hasMany = [ opcions : Opcio ]
	
    static constraints = {
		pregunta blank: false
    }
}
