package net.xaviersala;

import spock.lang.*

class UsuariIntegrationSpec extends Specification {

    def "Desar el primer usuari a la base de dades"() {

        given: "Nou usuari"
        def joe = new Usuari(userId: 'joe', contrasenya: 'secret')

        when: "usuari desat"
        joe.save()

        then: "es pot trobar a la base de dades"
        joe.errors.errorCount == 0
        joe.id != null
        Usuari.get(joe.id).userId == joe.userId

    }

    def "Fer canvis en un usuari existent"() {

        given: "Usuari existent"
        def existingUser = new Usuari(userId: 'joe', contrasenya: 'secret')
        existingUser.save(failOnError: true)

        when: "Canviem la contrasenya"
        def foundUser = Usuari.get(existingUser.id)    
        foundUser.contrasenya = 'sesame'
        foundUser.save(failOnError: true)

        then: "la contrasenya ha canviat en la base de dades"
        Usuari.get(existingUser.id).contrasenya == 'sesame'

    }
    
    def "Esborrar un usuari fa que desaparegui de la base de dades"() {

        given: "Usuari existent"
        def user = new Usuari(userId: 'joe', contrasenya: 'secret')
        user.save(failOnError: true)

        when: "Elimina l'usuari"
        def foundUser = Usuari.get(user.id)
        foundUser.delete(flush: true)

        then: "Ja no hi és a la base de dades"
        !Usuari.exists(foundUser.id)

    }
    
    def "Desar un usuari que no compleix les condicions genera un error"() {

        given: "Un usuari que no compleix les condicions"
        def user = new Usuari(userId: 'joe', contrasenya: 'tiny')

        when:  "es valida..."
        user.validate()

        then: "Es generen errors"
        user.hasErrors()

        "size.toosmall" == user.errors.getFieldError("contrasenya").code
        "tiny" == user.errors.getFieldError("contrasenya").rejectedValue
        !user.errors.getFieldError("userId")

        
    
    }

    def "Usuari amb errors pot modificar les propietats"() {

        given: "Usuari incorrecte"
        def chuck = new Usuari(userId: 'chuck', contrasenya: 'tiny')
        assert chuck.save()  == null
        assert chuck.hasErrors()

        when: "Es converteix en correcte"
        chuck.contrasenya = "fistfist"
        chuck.validate()

        then: "Es pot desar perquè valida"
        !chuck.hasErrors()
        chuck.save()
    
    }
	
	def "Usuari pot crear enquestes" () {
		given: "Un usuari"
		def joe = new Usuari(userId: 'joe', contrasenya:'secret').save()
		
		when: "Crea una enquesta"
		joe.addToEnquestes(new Enquesta(pregunta:"Quin color t'agrada més"))		
		
		then: "L'usuari té l'enquesta a la base de dades"
		1 == joe.enquestes.size()
	}

//    def "Ensure a user can follow other users"() {
//
//        given: "A set of baseline users"
//        def joe = new User(loginId: 'joe', password:'password').save()
//        def jane = new User(loginId: 'jane', password:'password').save()
//        def jill = new User(loginId: 'jill', password:'password').save()
//
//        when: "Joe follows Jane & Jill, and Jill follows Jane"
//        joe.addToFollowing(jane)
//        joe.addToFollowing(jill)
//        jill.addToFollowing(jane)
//
//        then: "Follower counts should match following people"
//        2 == joe.following.size()
//        1 == jill.following.size()
//        
//    }
    
}