package ch16

class Test{
    operator fun invoke(str: String){
        print(str)
    }
}

fun main(){
    val test = Test()
    test("wow")
}
