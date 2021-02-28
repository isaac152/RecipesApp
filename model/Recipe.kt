package model

class Recipe(id:Int){
    private val recipe: MutableMap<Ingredient,String> = mutableMapOf()
    private var id = 0
    init {
        this.id=id
    }
    fun addIngredient(ingredient: Ingredient){
        val measure = toStringMeasure(ingredient)
        recipe.put(ingredient,measure)
    }
    fun deleteIngredient(ingredient: Ingredient){
        recipe.remove(ingredient)
        println("Deleted : $ingredient")
    }
    private fun toStringMeasure(ingredient: Ingredient):String {
        return "${ingredient.amount} ${ingredient.measure}"
    }

    fun setId(id: Int){
        this.id=id
    }
    fun getId():Int{
        return this.id
    }
    fun getIngredients():String{
        var text:String = ""
        for (i in recipe){
            text += "-${i.key.ingredient} ${i.value} \n"
        }
        return text
    }

}