package org.trg

import grails.converters.JSON

class IdentificationController {
    def sql

    def list() {
        def ids = []
        sql.eachRow("SELECT * FROM identification_type"){idType ->
            ids.add("id": idType.id, "name": idType.name)
        }

        render ids as JSON
    }

    def show() {
        def id = Long.parseLong(params.id)
        def idType = sql.firstRow("SELECT * FROM identification_type WHERE id = ${id}")
        render idType as JSON
    }
}
