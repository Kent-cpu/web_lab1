fun main(args: Array<String>) {
    // Телефонная книга
    val mobilePhone = MobilePhone("89130782828")

    val contact1 = Contact("Ivan", "89502001323")
    val contact2 = Contact("Petr", "89503581607")
    val contact3 = Contact("Ruslan", "8913089213")

    mobilePhone.addNewContact(contact1)
    mobilePhone.addNewContact(contact2)
    mobilePhone.addNewContact(contact3)
    mobilePhone.printContacts()

    val contact4 = Contact("Nikita", "89123121257")
    mobilePhone.addNewContact(contact4)
    mobilePhone.printContacts()


    val contact5 = Contact("Elizaveta", "89501231092")
    mobilePhone.updateContact(contact1, contact5)
    mobilePhone.printContacts()

    mobilePhone.removeContact(contact3)
    mobilePhone.printContacts()

    // Бинарное дерево
    val tree = BinaryTree()
    tree.insert(5)
    tree.insert(3)
    tree.insert(7)
    tree.insert(2)
    tree.insert(4)
    tree.insert(6)
    tree.insert(8)


    tree.traverse()

    println("Search 9:")
    println(tree.search(9))

    println("Remove 7:")
    tree.remove(7)
    tree.traverse() // 2 3 4 5 6 8
}