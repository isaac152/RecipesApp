package model

class RecipeBook {
    val recipes: MutableList<Recipe> = mutableListOf()
    fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
        println("Added the recipe: ${recipe.getId()}")
    }

    fun printBook() {
        println(":Recipe Book:")
        for (i in recipes){
            println("Recipe :${i.getId()} ")
            println("------------------\n ${i.getIngredients()}\n------------------\n")
        }
    }
}
