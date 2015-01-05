import net.xaviersala.Enquesta
import net.xaviersala.Opcio
import net.xaviersala.Usuari

class BootStrap {

	def init = { servletContext ->
		def admin = new Usuari(userId:"admin",contrasenya:"secret").save()
		admin.addToEnquestes(new Enquesta(nomEnquesta: "Colors", pregunta: "Quin color prefereixes?"))
		admin.enquestes[0].addToOpcions(new Opcio(text:"blau",vots:0))
		admin.enquestes[0].addToOpcions(new Opcio(text:"vermell", vots:0))
		admin.save()
		}
		def destroy = {
		}
}
