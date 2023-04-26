

class MobilePhone(val myNumber: String) {
    private val myContacts = ArrayList<Contact>()

    fun addNewContact(contact: Contact): Boolean {
        if (findContact(contact) >= 0) {
            return false
        }
        myContacts.add(contact)
        return true
    }

    fun updateContact(oldContact: Contact, newContact: Contact): Boolean {
        val position = findContact(oldContact)
        if (position < 0) {
            return false
        }
        myContacts[position] = newContact
        return true
    }

    fun removeContact(contact: Contact): Boolean {
        val position = findContact(contact)
        if (position < 0) {
            return false
        }
        myContacts.removeAt(position)
        return true
    }

    fun findContact(contact: Contact): Int {
        return myContacts.indexOf(contact)
    }

    fun queryContact(name: String): Contact? {
        for (contact in myContacts) {
            if (contact.name == name) {
                return contact
            }
        }
        return null
    }

    fun printContacts() {
        println("Контакты")
        for (i in 0 until myContacts.size) {
            println("${i + 1}. ${myContacts[i].name}: ${myContacts[i].phoneNumber}")
        }
    }
}
