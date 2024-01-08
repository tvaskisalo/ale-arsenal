import { z } from 'zod'

export const addOwnBeerSchema = z.object({
	name: z.string(),
	bottleSize: z.number().optional(),
	kegSize: z.number().optional(),
	bottleAmount: z.number().optional(),
	kegAmount: z.number().optional(),
	abv: z.number().optional(),
	style: z.string(),
	brewDate: z.string(),
	description: z.string(),
})
