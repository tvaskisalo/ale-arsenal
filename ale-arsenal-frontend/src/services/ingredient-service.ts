import { api } from '../main.tsx'
import { addIngredientCommand } from '../types/ingredientTypes.ts'

export const addIngredient = async (ingredient: addIngredientCommand) => {
	return await api.apiIngredientPost({
		name: ingredient.name,
		amount: ingredient.amount,
		ingredientType: ingredient.ingredientType,
	})
}
