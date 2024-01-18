import { z } from 'zod'

export const addIngredientSchema = z.object({
	name: z.string(),
	amount: z.number(),
	ingredientType: z.string(),
})

export const ingredientSchema = z.object({
	id: z.number(),
	name: z.string(),
	amount: z.number(),
	ingredientType: z.string(),
})
