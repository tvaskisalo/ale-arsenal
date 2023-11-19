import { addIngredientCommand } from '../types/ingredientTypes.ts'
import { api } from './api.tsx'

export const addIngredient = async (ingredient: addIngredientCommand) => {
	return await api.apiIngredientPost({
		name: ingredient.name,
		amount: ingredient.amount,
		ingredientType: ingredient.ingredientType,
	})
}
