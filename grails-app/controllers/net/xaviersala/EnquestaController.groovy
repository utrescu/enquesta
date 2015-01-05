package net.xaviersala

class EnquestaController {

	def opcionsService
    
	static scaffold = true
	def cerca() {}

	def resultats(String pregunta) {
		def preguntes = Enquesta.where { pregunta =~ "%${pregunta}%" }.list()
		return [ preguntes: preguntes,
				 term: params.pregunta,
				 totalPreguntes: Enquesta.count() ]
	}

	def llista() {
		def usuari = Usuari.findByUserId(params.id)
		if (!usuari) {
			response.sendError(404)
		} else {
			[ usuari : usuari ]
		}
	}
	
	// Crear una nova enquesta
	def nova() {
		
	}
	
	def afegir() {
		flash.message = "Successfully created Post"
	}
	
	def vota() {
		def enquesta = Enquesta.get(params.id)
		if (!enquesta) {
			response.sendError(404)
		} else {
			[ enquesta : enquesta ]
		}
	}
	
	def gracies() {
		def vot = Opcio.get(params.vots)
		if (!vot) {
			response.sendError(404)
		} else {
		// És millor fer les transaccions en un "service" perquè si no a
		// vegades no desa inmediatament i el que es fa en un service és
		// si tot acaba bé, una transacció.
			opcionsService.incrementaVots(vot)			
			[enquesta: vot.enquesta]
		}	
	}

}
