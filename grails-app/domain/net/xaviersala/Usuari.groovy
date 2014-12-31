package net.xaviersala

class Usuari {

	String userId
	String contrasenya
	String nomComplet
	Date dateCreated
	
    static constraints = {
		userId size: 3..20, unique: true, nullable: false
		contrasenya size: 6..8, blank: false, validator: { passwd, user ->
			passwd != user.userId
			}
		nomComplet nullable: true
    }
	
	static hasMany = [ enquestes : Enquesta ]
}
