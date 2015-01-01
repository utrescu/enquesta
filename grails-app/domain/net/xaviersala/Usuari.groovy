package net.xaviersala

class Usuari {

	String userId
	String contrasenya
	String nomComplet
	Date dateCreated
	
    static constraints = {
		userId size: 3..20, unique: true, nullable: false
		contrasenya size: 6..8, blank: false, password: true, validator: { passwd, user ->
			passwd != user.userId
			}
		nomComplet nullable: true
    }
	
	String toString() {
		"$userId"
	}
	
	static hasMany = [ enquestes : Enquesta ]
}
