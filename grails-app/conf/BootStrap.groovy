import net.xaviersala.Usuari

class BootStrap {

	def init = { servletContext ->
		new Usuari(userId:"admin",contrasenya:"secret").save()
		}
		def destroy = {
		}
}
