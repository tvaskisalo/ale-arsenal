import { addIngredientCommand } from '../types/ingredient-types.ts'
import { api } from './api.tsx'

export const addIngredient = async (ingredient: addIngredientCommand) => {
	return await api.apiIngredientPost({
		...ingredient,
	})
}
