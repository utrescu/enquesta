package net.xaviersala

class EnquestaController {

    
	static scaffold = true
	def search() {}

	def results(String pregunta) {
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
	
	def afegirEnquesta() {
		flash.message = "Successfully created Post"
	}

}
