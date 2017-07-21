package com.aruistart.study.examples

data class User(var name: String, var age: Int) {
//    override fun equals(other: Any?): Boolean {
//        return name == (other as User).name
//    }
}

fun main(args: Array<String>) {
    val x = 3
    val y = 10
    if (x in 1..y) {
        println("ok")
    }

    val array = arrayListOf<String>()
    array.add("aaa")
    array.add("bbb")
    array.add("ccc")

    println("aaa" in array)

    val userArray = arrayListOf<User>()
    userArray.add(User("xiaoming", 3))
    userArray.add(User("xiaohong", 4))
    userArray.add(User("xiaobing", 5))

    println(User("xiaoming", 5) in userArray)
    println(User("xiaoming", 3) in userArray)

    (1..4).map { println(it) }
}