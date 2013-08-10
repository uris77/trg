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

    def create() {
        def jsonParams = request.JSON
        def name = jsonParams.name
        def id = jsonParams.id
        def insertStatement = "INSERT INTO identification_type(id, name) VALUES(${id}, ${name})"
        def idType = sql.executeInsert(insertStatement)
        render idType as JSON
    }

    def search() {
        def idTypes = []
        println "params: ${params}"
        def query = "SELECT * FROM identification_type WHERE name = " + params.name
        sql.eachRow(query){idType->
            idTypes.add("id": idType.id, "name": idType.name)
        }
        render idTypes as JSON
    }
}
