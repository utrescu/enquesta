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


}
