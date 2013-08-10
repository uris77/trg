import org.trg.District

class BootStrap {

    def init = { servletContext ->

        new District(name: 'Corozalito', code:'CZ').save()
        new District(name: 'Naranjas', code: 'OW').save()
        new District(name: 'Belize', code: 'BZ').save()
        new District(name: 'Hilly', code:'CY').save()
        new District(name: 'Real Oranges', code: 'SC').save()
        new District(name: 'Fishing', code: 'TO').save()
    }
    def destroy = {
    }
}
