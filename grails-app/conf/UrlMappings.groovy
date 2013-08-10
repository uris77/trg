class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/district" {
            controller = "district"
            action = [GET: "list",
                POST: "create"]
        }

        "/district/$id" {
            controller = "district"
            action = [GET: "show",
                PUT: "update",
                DELETE: "delete"]
        }

        "/identification"{
            controller = "identification"
            action = [GET: "list", POST: "create"]
        }

        "/identification/$id"{
            controller = "identification"
            action = [GET: "show"]
        }

        "/identification/search"{
            controller = "identification"
            action = [GET: "search"]
        }

        "/people/list"{
            controller = "people"
            action = [GET: "list"]
        }

        "/people/search"{
            controller = "people"
            action = [GET: "findByStreet"]
        }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
