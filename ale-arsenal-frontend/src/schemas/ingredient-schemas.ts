import { z } from 'zod'

export const addIngredientSchema = z.object({
	name: z.string(),
	amount: z.number(),
	ingredientType: z.string(),
})
