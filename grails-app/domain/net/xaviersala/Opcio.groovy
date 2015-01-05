package net.xaviersala

class Opcio {

	String textOpcio
	Long vots = 0
	
    static constraints = {
    	textOpcio nullable: false, blank: false
		vots min:0L
		}
	
	static mapping = {		
		vots defaultValue: "0"
		sort "text"		
	 }
	
	static belongsTo = [ enquesta: Enquesta ]
	
	String toString() {
		"$textOpcio" + " : " + vots
	}
	
	 
}
