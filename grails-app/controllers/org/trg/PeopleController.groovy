package org.trg

import grails.converters.JSON
import groovy.json.StringEscapeUtils

class PeopleController {
    def sql
    private static String LIST_QUERY = """
        SELECT p.id, first_name, last_name, s.name as sex
        FROM person as p
        LEFT JOIN sex as s ON p.sex_id = s.id
    """


    def list() {
        def people = []
        def max = params.max ?: 100
        def offset = params.offset ?: 0
        sql.eachRow(LIST_QUERY, offset, max){
            people.add([id: it.id,
                name: "${it.first_name} ${it.last_name}",
                sex: "${it.sex}"])
        }
        render people as JSON
    }

    def findByStreet() {
        def FIND_BY_ADDRESS_QUERY = """
            SELECT p.id first_name, last_name, a.street
            FROM person as p
            INNER JOIN address as a on p.id = a.person_id
            WHERE a.street LIKE
        """
        def street = params.street + '%'
        def _street = street.minus("%'")
        def people = sql.rows(FIND_BY_ADDRESS_QUERY + _street.replaceAll("'%", "%'"))

        render people as JSON

    }


}
