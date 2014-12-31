package net.xaviersala

class Opcio {

	String text
	Long vots
	
    static constraints = {
    	text nullable: false, blank: false
		}
	
	static belongsTo = [enquesta: Enquesta]
}
