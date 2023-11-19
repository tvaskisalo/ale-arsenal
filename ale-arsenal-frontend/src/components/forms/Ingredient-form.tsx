import { zodResolver } from '@hookform/resolvers/zod'
import { SubmitHandler, useForm } from 'react-hook-form'

import { addIngredientSchema } from '../../schemas/ingredient-schemas.ts'
import { addIngredient } from '../../services/ingredient-service.ts'
import { addIngredientCommand } from '../../types/ingredientTypes.ts'

const IngredientForm = () => {
	const { register, handleSubmit } = useForm<addIngredientCommand>({
		resolver: zodResolver(addIngredientSchema),
	})
	const onSubmit: SubmitHandler<addIngredientCommand> = async (data) => {
		const id = await addIngredient(data)
		// eslint-disable-next-line no-console
		console.log(id)
	}
	return (
		<form onSubmit={handleSubmit(onSubmit)}>
			<div>NAME: </div>
			<input {...register('name')} />
			<div>AMOUNT</div>
			<input {...register('amount', { valueAsNumber: true })} />
			<div>INGREDIENTTYPE</div>
			<input {...register('ingredientType')} />
			<input type="submit" />
		</form>
	)
}

export default IngredientForm
