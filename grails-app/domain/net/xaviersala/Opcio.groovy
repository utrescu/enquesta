package net.xaviersala

class Opcio {

	String text
	Long vots
	
    static constraints = {
    	text nullable: false, blank: false
		}
	
	static mapping = {		
		vots defaultValue: "0"
	 }
	
	static belongsTo = [enquesta: Enquesta]
	
	String toString() {
		"$text"
	}
}
