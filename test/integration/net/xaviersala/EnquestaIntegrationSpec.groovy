package net.xaviersala



import spock.lang.*

/**
 *
 */
class EnquestaIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

	def "Comprovar que l'enquesta pot tenir opcions"() {
	given: "Donat un usuari amb una enquesta"
	Usuari nou = new Usuari( userId:"xavier", contrasenya:"secret")
	nou.addToEnquestes(new Enquesta(pregunta: "Quin color prefereixes?"))
	nou.enquestes[0].addToOpcions(new Opcio(textOpcio:"blau"))
	nou.enquestes[0].addToOpcions(new Opcio(textOpcio:"vermell"))
	
	
	when: "es desa l'usuari"
	nou.save()
	
	then: "Hi ha dues opcions en l'enquesta"
	nou.errors.errorCount == 0
	nou.id != null
	Usuari.get(nou.id).enquestes[0].opcions.size() == 2

	
	
	}
}
