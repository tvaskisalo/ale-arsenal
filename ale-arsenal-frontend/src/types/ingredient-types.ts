import { z } from 'zod'

import { addIngredientSchema } from '../schemas/ingredient-schemas.ts'

export type addIngredientCommand = z.infer<typeof addIngredientSchema>
