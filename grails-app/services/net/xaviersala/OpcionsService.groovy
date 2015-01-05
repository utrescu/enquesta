package net.xaviersala

import grails.transaction.Transactional

@Transactional
class OpcionsService {

    def incrementaVots(vot) {
		vot.vots = vot.vots + 1
		vot.save()
    }
}
