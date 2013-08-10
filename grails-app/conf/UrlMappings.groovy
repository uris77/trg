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

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
