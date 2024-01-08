import { addOwnBeerCommand } from '../types/own-beer-types.ts'
import { api } from './api.tsx'

export const addOwnBeer = async (ownBeer: addOwnBeerCommand) => {
	return await api.apiOwnBeerPost({
		...ownBeer,
	})
}
