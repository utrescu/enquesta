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
			vot.vots = vot.vots + 1
			vot.save()
			render("OK")
		}	
	}

}
