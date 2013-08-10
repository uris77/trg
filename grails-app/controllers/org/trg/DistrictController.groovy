package org.trg

import grails.converters.JSON
import grails.converters.XML

class DistrictController {

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        request.withFormat {
            xml {
                render(District.list() as XML)
            }
            json {
                render(District.list() as JSON)
            }
        }
    }

    def create() {
        def jsonParams = request.JSON
        def district = new District(jsonParams)
        if(district.validate()) {
            render(district as JSON)
        }else {
         render([error: "An error occurred."] as JSON)
        }
    }

    def show() {
        def district = District.get(params.id)
        request.withFormat{
            json {
                render(district as JSON)
            }
            xml {
                render(district as XML)
            }
        }
    }

    def update() {
        def district = District.get(params.id)
        if (!district) {
            response.status = 401
            render([error: "The district does not exist"] as JSON)
        } else {
            district.properties = request.JSON
            district.save()
            response.status = 201
            render(district as JSON)
        }
    }

    def delete() {
        def district = District.get(params.id)
        if (!district) {
            response.status = 401
            render(
                [error: "District you tried to delete does not exist"] as JSON)
        } else {
            district.delete()
            response.status = 200
            render(district as JSON)
        }
    }
}
