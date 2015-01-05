package net.xaviersala

class Opcio {

	String text
	Long vots = 0
	
    static constraints = {
    	text nullable: false, blank: false
		vots min:0L
		}
	
	static mapping = {		
		vots defaultValue: "0"
		sort "text"		
	 }
	
	static belongsTo = [enquesta: Enquesta]
	
	String toString() {
		"$text" + vots
	}
	
	 
}
