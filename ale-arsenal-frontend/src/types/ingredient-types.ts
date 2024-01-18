import { z } from 'zod'

import {
	addIngredientSchema,
	ingredientSchema,
} from '../schemas/ingredient-schemas.ts'

export type addIngredientCommand = z.infer<typeof addIngredientSchema>

export type Ingredient = z.infer<typeof ingredientSchema>
