import { ingredientSchema } from '../schemas/ingredient-schemas.ts'
import { addIngredientCommand, Ingredient } from '../types/ingredient-types.ts'
import { api } from './api.tsx'

export const addIngredient = async (ingredient: addIngredientCommand) => {
	return await api.apiIngredientPost({
		...ingredient,
	})
}

export const getIngredients = async (): Promise<Ingredient[]> => {
	const ingredients = await api.apiIngredientGet()
	console.log(ingredients)
	return ingredients.data.map((ingredient) =>
		ingredientSchema.parse(ingredient),
	)
}
