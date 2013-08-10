package org.trg

import grails.converters.JSON

class IdentificationController {
    def sql

    def list() {
        def ids = []
        sql.eachRow("SELECT * FROM identification_type"){
            ids.add(["id": it.id, "name": it.name])
        }

        render ids as JSON
    }

    def show() {
        def requestedId = Long.parseLong(params.id)
        String query = """
            SELECT * FROM identification_type
            WHERE id = :id
        """
        def idType = sql.firstRow(query, [id: requestedId])

        if(idType){
            render idType as JSON
        } else {
            render(["No Results"] as JSON)
        }

    }
}
