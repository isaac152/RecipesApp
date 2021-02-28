package model

class Menu {
    var counterRecipe=1
    val book: RecipeBook=RecipeBook()
    val menuIngredientes = """
        <-----> Ingredient Menu <----->
        Select the desired option
        1. Water
        2. Milk
        3. Oil
        4. Meats
        5. Vegetables
        6. Fruits
        7. Cereal
        8. Eggs
        9. Exit
    """.trimIndent()
    val menu = """
        Select the desired option
            1. Make a recipe
            2. See my recipes
            3. Exit
    """.trimIndent()
    companion object UI{
        fun create():Menu=Menu()
    }
    private fun insertIngredientValues():Pair<Int,String>{
        print("\n Amount: ")
        val amount: Int = readLine()?.toIntOrNull()?:0
            print("\n Measure: ")
        val measure: String = readLine()?.toString()?:"unity"
        return Pair(amount,measure)
    }
    private fun menuIngredient(index: Int):Ingredient{
        var aux:Ingredient?=null
        when (index){
            1 ->{aux = Water()}
            2 ->{aux = Milk()}
            3 ->{aux = Oil()}
            4->{aux = Meat(); aux.menuOptions()}
            5->{aux = Vegetable();aux.menuOptions()}
            6->{aux = Fruit(); aux.menuOptions()}
            7->{aux=Cereal();aux.menuOptions()}
            8->{aux =Egg();aux.menuOptions()}
        }
        val pairValues =insertIngredientValues()
        aux?.amount=pairValues.first
        aux?.measure=pairValues.second
        return aux?:Water()
    }
    private fun menuRecipe(){
        val newrecipe = Recipe(counterRecipe)
        while(true) {
            println(menuIngredientes)
            print("Select the desired option ")
            val response: String? = readLine()
            val index = response?.toInt() ?: 1
            if(index in 1..8){
                val ingredient = menuIngredient(index)
                newrecipe.addIngredient(ingredient)
            }
            else
                break
      }
        book.addRecipe(newrecipe)
        counterRecipe++
    }
    fun welcome(){
        println(":: Welcome to Recipe Maker ::\n")
        while (true){
            println(menu)
            val option:String? = readLine()
            when(option){
                "1" ->menuRecipe()
                "2" ->book.printBook()
                "3" -> break
                else->println("Error, try again")
            }
        }
    }

}