import { z } from 'zod'

import { addOwnBeerSchema } from '../schemas/own-beer-schemas.ts'

export type addOwnBeerCommand = z.infer<typeof addOwnBeerSchema>
