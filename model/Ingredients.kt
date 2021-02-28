package model

abstract  class Ingredient(amount:Int=1,measure:String="Unity") {
    var amount = amount;
    var measure = measure
    open var ingredient: String =""
}

abstract class SolidIngredient(amount:Int=1,measure:String="Unity"): Ingredient(amount,measure){
    open var variety: List<String> = listOf()
    override var ingredient: String =""
    open fun printOptions(){
        println("List of available options")
        var counter= 1
        for (i in variety){
            println("${counter++}-$i")
        }
    }
    open fun menuOptions(){
        printOptions()
        val response: String? = readLine()
        val index = response?.toInt() ?: 1
        if((index>0)&&(index<variety.size)){
            choice(index-1)
        }
        else {
            println("Error index")
            menuOptions()
        }
    }
    open fun choice(option: Int){
        this.ingredient= variety.get(option)
    }

}
abstract class LiquidIngredient(amount:Int=1,measure:String="Ml"): Ingredient(amount,measure){
    override var ingredient: String =""
}

class Water(amount:Int=1,measure:String="Ml"): LiquidIngredient(amount,measure){
    override var ingredient: String ="Water"
}
class Oil(amount:Int=1,measure:String="Ml"): LiquidIngredient(amount,measure){
    override var ingredient: String ="Oil"

}
class Milk(amount:Int=1,measure:String="Ml"): LiquidIngredient(amount,measure){
    override var ingredient: String ="Milk"
}

class Meat(amount:Int=1,measure:String="Unity"):SolidIngredient(amount,measure){
    override var variety =listOf("Pig","Cow","Chicken","Fish")
}
class Vegetable(amount:Int=1,measure:String="Unity"):SolidIngredient(amount,measure){
    override var variety =listOf("Tomatoe","Lettuce","Eggplant","Pumpkin")

}
class Fruit(amount:Int=1,measure:String="Unity"):SolidIngredient(amount,measure){
    override var variety =listOf("Grape","Apple","Pear","Banana","Orange","Stawberry","Cherry")

}
class Egg(amount:Int=1,measure:String="Unity"):SolidIngredient(amount,measure){
    override var variety =listOf("Brown","White","Caviar")

}
class Cereal(amount:Int=1,measure:String="Unity"):SolidIngredient(amount,measure){
    override var variety =listOf("Rice","Wheat","Oat","Corn")

}