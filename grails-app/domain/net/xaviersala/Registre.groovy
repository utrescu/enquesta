package net.xaviersala

class Registre {

	String ip
	String email
	Date dateCreated
	Integer vot
	
	static belongsTo = [enquesta: Enquesta]
	
    static constraints = {
		ip nullable: false
		email blank:true
		vot nullable: false
    }
	

}
