package org.trg

class District {
    String name
    String code

    static constraints = {
        name blank: false, nullable: false
        code blank: false, nullable: false
    }
}
