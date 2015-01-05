package net.xaviersala

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(EnquestaController)
@Mock([Usuari,Enquesta])
class EnquestaControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "Obtenir totes les enquestes d'un usuari"() {
		given: "Usuari del que volem obtenir les enquestes"
		Usuari nou = new Usuari( userId:"xavier", contrasenya:"secret")
		nou.addToEnquestes(new Enquesta(pregunta: "Quin color prefereixes?"))
		nou.addToEnquestes(new Enquesta(pregunta: "Quin esport prefereixes?"))
		nou.save(failOnError:true)
		
		and: "Paràmetre id"
		params.id = nou.userId
		
		when: "Es vol veure la llista d'enquestes"
		def model = controller.llista()
		
		then: "L'usuari està en el model especificat"
		model.usuari.userId == "xavier"
		model.usuari.enquestes.size() == 2
	}
	
	def "Comprova que un usuari no existent dóna 404"() {
		given: "Un id d'un usuari que no existeix"
		params.id = "no-existeix"
		
		when: "Al accedir a la llista"
		controller.llista()
		
		then: "rep un error 404"
		response.status == 404				
	}
	
	def "Comprova que els vots es desen"() {
		given: "Una enquesta en la base de dades"
		Usuari nou = new Usuari( userId:"xavier", contrasenya:"secret")
		nou.addToEnquestes(new Enquesta(pregunta: "Quin color prefereixes?"))
		nou.enquestes.first().addToOpcions(new Opcio(text:"blau"))
		nou.enquestes[0].addToOpcions(new Opcio(text:"vermell"))
		nou.save(failOnError:true)
		
		when: "Al votar una opció"
		params.vots = nou.enquestes[0].opcions[0].id
		def model = controller.vota()
		
		then: "La opció té un vot"		
		model.usuari.userId == "xavier"
		model.enquestes[0].opcions.getAt(0) == 1
	}
	

	
}
