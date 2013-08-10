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
            action = [GET: "list"]
        }

        "/identification/$id"{
            controller = "identification"
            action = [GET: "show"]
        }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
